package com.example.internshiptestfathan.menu.list.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshiptestfathan.menu.list.models.response.PlaceResponseModel
import com.example.internshiptestfathan.network.repositories.PlaceRepository

class MainViewModel : ViewModel() {

    private var allData = MutableLiveData<PlaceResponseModel>()
    private val placeRepository = PlaceRepository(viewModelScope)
    var isLoading: ObservableBoolean = ObservableBoolean()

    internal fun setData(){

        isLoading.set(true)

        placeRepository.getPlace({
            allData.postValue(it)
        },{
            //Log.e("Place", it.message)
        }
        )
        isLoading.set(false)

    }

    internal fun getAllData() : LiveData<PlaceResponseModel>{
        return allData
    }

}