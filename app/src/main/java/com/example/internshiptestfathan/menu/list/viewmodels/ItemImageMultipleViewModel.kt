package com.example.internshiptestfathan.menu.list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class ItemImageMultipleViewModel(imageUrl: String?): ViewModel() {
    var imageUrl: ObservableField<String?> = ObservableField(imageUrl)
}