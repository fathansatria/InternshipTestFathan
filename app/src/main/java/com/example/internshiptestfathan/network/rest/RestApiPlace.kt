package com.example.internshiptestfathan.network.rest

import com.example.internshiptestfathan.menu.list.models.response.PlaceResponseModel
import com.example.internshiptestfathan.network.basemodels.ApiServiceModel
import retrofit2.Response
import retrofit2.http.GET

interface RestApiPlace {

    @GET("place.json")
    suspend fun place(): Response<ApiServiceModel<PlaceResponseModel>>

}