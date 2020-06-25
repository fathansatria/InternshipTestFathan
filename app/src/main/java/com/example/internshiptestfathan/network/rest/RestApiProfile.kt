package com.example.internshiptestfathan.network.rest

import com.example.internshiptestfathan.menu.profile.models.ProfileModel
import com.example.internshiptestfathan.network.basemodels.ApiServiceModel
import retrofit2.Response
import retrofit2.http.GET

interface RestApiProfile {

    @GET("user.json")
    suspend fun profile(): Response<ApiServiceModel<ProfileModel>>

}