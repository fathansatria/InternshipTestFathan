package com.example.internshiptestfathan.menu.gallery.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel

class GalleryDetailViewModel(galleryModel: GalleryModel?): ViewModel() {

    var imageUrl: ObservableField<String?> = ObservableField(galleryModel?.image)
    var caption: ObservableField<String?> = ObservableField(galleryModel?.caption)

}