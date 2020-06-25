package com.example.internshiptestfathan.network.rest

import com.example.internshiptestfathan.menu.gallery.models.GalleryModel
import com.example.internshiptestfathan.network.basemodels.ApiServiceModelList
import retrofit2.Response
import retrofit2.http.GET

interface RestApiGallery {

    @GET("gallery.json")
    suspend fun gallery(): Response<ApiServiceModelList<GalleryModel>>

}