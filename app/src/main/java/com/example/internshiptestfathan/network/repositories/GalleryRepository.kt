package com.example.internshiptestfathan.network.repositories


import com.example.internshiptestfathan.menu.gallery.models.GalleryModel
import com.example.internshiptestfathan.network.ServiceFactory
import com.example.internshiptestfathan.network.rest.RestApiGallery
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class GalleryRepository(private val scope: CoroutineScope) {

    private val restApi = ServiceFactory.getApiService(RestApiGallery::class.java)

    fun getGallery(onSuccess:(MutableList<GalleryModel>?) -> Unit, onError:(Throwable) -> Unit) {
        scope.launch {
            try {
                val result = restApi.gallery()
                onSuccess(result.body()?.data)
            } catch (throwable: Throwable) {
                if (throwable !is CancellationException) {
                    onError(throwable)
                }
            }
        }
    }

}