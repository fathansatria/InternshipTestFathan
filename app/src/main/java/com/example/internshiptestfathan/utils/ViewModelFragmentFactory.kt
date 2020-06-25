package com.example.internshiptestfathan.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel
import com.example.internshiptestfathan.menu.gallery.viewmodels.GalleryDetailViewModel
import com.example.internshiptestfathan.menu.list.models.PlaceModel
import com.example.internshiptestfathan.menu.list.viewmodels.MultipleDetailViewModel
import com.example.internshiptestfathan.menu.list.viewmodels.SingleDetailViewModel


class ViewModelFragmentFactory(private val params: Any): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == SingleDetailViewModel::class.java) {
            return SingleDetailViewModel(params as PlaceModel) as T
        } else if (modelClass == MultipleDetailViewModel::class.java) {
            return MultipleDetailViewModel(params as PlaceModel) as T
        } else if (modelClass == GalleryDetailViewModel::class.java) {
            return GalleryDetailViewModel(params as GalleryModel) as T
        }
        return super.create(modelClass)
    }
}