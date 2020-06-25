package com.example.internshiptestfathan.menu.gallery.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel

class ItemGalleryViewModel(gallery: GalleryModel): ViewModel() {
    var imageUrl: ObservableField<String?> = ObservableField(gallery.thumbnail)
}