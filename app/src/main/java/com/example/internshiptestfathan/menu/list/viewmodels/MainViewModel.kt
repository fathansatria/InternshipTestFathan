package com.example.internshiptestfathan.menu.list.viewmodels

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshiptestfathan.data.db.DbPlaceRepository
import com.example.internshiptestfathan.menu.list.models.response.PlaceResponseModel
import com.example.internshiptestfathan.network.repositories.PlaceRepository

class MainViewModel(context: Context) : ViewModel() {

    private var allData = MutableLiveData<PlaceResponseModel>()
    private val placeRepository = PlaceRepository(viewModelScope)
    private val dbPlaceRepository = DbPlaceRepository(context)

    var isLoading: ObservableBoolean = ObservableBoolean()

    internal fun setData(){

        isLoading.set(true)
        dbPlaceRepository.getPlaces {
            Log.i("ISINYA", it.toString())
            allData.postValue(it)
        }
        isLoading.set(false)

    }

    internal fun getAllData() : LiveData<PlaceResponseModel>{
        return allData
    }

}