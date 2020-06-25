package com.example.internshiptestfathan.network.repositories


import com.example.internshiptestfathan.menu.profile.models.ProfileModel
import com.example.internshiptestfathan.network.ServiceFactory
import com.example.internshiptestfathan.network.rest.RestApiProfile
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ProfileRepository(private val scope: CoroutineScope) {

    private val restApi = ServiceFactory.getApiService(RestApiProfile::class.java)

    fun getProfile(onSuccess:(ProfileModel?) -> Unit, onError:(Throwable) -> Unit) {
        scope.launch {
            try {
                val result = restApi.profile()
                onSuccess(result.body()?.data)
            } catch (throwable: Throwable) {
                if (throwable !is CancellationException) {
                    onError(throwable)
                }
            }
        }
    }

}