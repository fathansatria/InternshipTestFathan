package com.example.internshiptestfathan.menu.gallery.viewmodels

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel
import com.example.internshiptestfathan.network.repositories.GalleryRepository

class GalleryViewModel : ViewModel() {

    var listGallery: MutableLiveData<MutableList<GalleryModel>> = MutableLiveData()
    private val galleryRepository = GalleryRepository(viewModelScope)
    var isLoading: ObservableBoolean = ObservableBoolean()


    fun getGalleryData(){
        galleryRepository.getGallery({

            isLoading.set(true)
            Log.i("DATA", it.toString())
            listGallery.postValue(it)
            isLoading.set(false)


        },{
            //Log.e("Gallery", it.message)
        }
        )
    }

}