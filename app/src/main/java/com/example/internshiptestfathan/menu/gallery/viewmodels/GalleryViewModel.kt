package com.example.internshiptestfathan.menu.gallery.viewmodels

import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.example.internshiptestfathan.data.db.DbGalleryRepository
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel
import com.example.internshiptestfathan.network.repositories.GalleryRepository

class GalleryViewModel(context: Context) : ViewModel() {

    var listGallery: MutableLiveData<MutableList<GalleryModel>> = MutableLiveData()
    private val galleryRepository = GalleryRepository(viewModelScope)
    private val dbGalleryRepository = DbGalleryRepository(context)
    var isLoading: ObservableBoolean = ObservableBoolean()


    fun getGalleryData(){
        dbGalleryRepository.getGalleries {
            listGallery.postValue(it)
        }
    }

}