package com.example.internshiptestfathan.main.views

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.internshiptestfathan.data.db.DbGalleryRepository
import com.example.internshiptestfathan.data.db.DbPlaceRepository
import com.example.internshiptestfathan.network.repositories.GalleryRepository
import com.example.internshiptestfathan.network.repositories.PlaceRepository

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val galleryRepository = GalleryRepository(viewModelScope)
    private val placeRepository = PlaceRepository(viewModelScope)
    private val dbGalleryRepository = DbGalleryRepository(application.applicationContext)
    private val dbPlaceRepository = DbPlaceRepository(application.applicationContext)

    var isGalleriesDone: MutableLiveData<Boolean> = MutableLiveData(false)
    var isPlaceDone: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getGallery() {
        galleryRepository.getGallery({ listGallery ->
            listGallery?.forEach { gallery ->
                dbGalleryRepository.insertGalleries(gallery)
            }
            isGalleriesDone.postValue(true)
        },{
            //logError("SplashViewModel # failed get posts")
        })
    }

    fun getPlaces() {
        placeRepository.getPlace({ places ->
            dbPlaceRepository.insertPlace(places)
            isPlaceDone.postValue(true)
        },{
            //logError("SplashViewModel # failed get posts")
        })
    }
}