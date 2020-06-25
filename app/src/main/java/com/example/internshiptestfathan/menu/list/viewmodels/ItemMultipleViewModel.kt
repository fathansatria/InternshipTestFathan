package com.example.internshiptestfathan.menu.list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.internshiptestfathan.menu.list.models.PlaceModel

class ItemMultipleViewModel(placeModel: PlaceModel): ViewModel() {
    var title: ObservableField<String?> = ObservableField(placeModel.title)
    var content: ObservableField<String?> = ObservableField(placeModel.content)
}