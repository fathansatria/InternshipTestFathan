package com.example.internshiptestfathan.data.db

import android.content.Context
import android.os.AsyncTask
import com.example.internshiptestfathan.menu.list.models.response.PlaceResponseModel



class DbPlaceRepository(context: Context) {

    private val dbPlace = AppDatabase.getInstance(context)?.placeDaoAccess()

    fun insertPlace(placeResponseModel: PlaceResponseModel?) {
        AsyncTask.execute { dbPlace?.insertPlace(placeResponseModel) }
    }

    fun getPlaces(placeResponseModel:(PlaceResponseModel?) -> Unit) {
        AsyncTask.execute { placeResponseModel(dbPlace?.placeResponses())}
    }
}