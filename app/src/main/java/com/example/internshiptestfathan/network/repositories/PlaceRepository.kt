package com.example.internshiptestfathan.network.repositories

import com.example.internshiptestfathan.menu.list.models.response.PlaceResponseModel
import com.example.internshiptestfathan.network.ServiceFactory
import com.example.internshiptestfathan.network.rest.RestApiPlace
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PlaceRepository(private val scope: CoroutineScope) {

    private val restApi = ServiceFactory.getApiService(RestApiPlace::class.java)

    fun getPlace(onSuccess:(PlaceResponseModel?) -> Unit, onError:(Throwable) -> Unit) {
        scope.launch {
            try {
                val result = restApi.place()
                onSuccess(result.body()?.data)
            } catch (throwable: Throwable) {
                if (throwable !is CancellationException) {
                    onError(throwable)
                }
            }
        }
    }

}