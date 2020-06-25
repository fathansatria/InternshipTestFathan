package com.example.internshiptestfathan.menu.list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.internshiptestfathan.menu.list.models.PlaceModel

class SingleDetailViewModel(placeModel: PlaceModel?): ViewModel() {

    var imageUrl: ObservableField<String?> = ObservableField(placeModel?.image)
    var title: ObservableField<String?> = ObservableField(placeModel?.title)
    var content: ObservableField<String?> = ObservableField(placeModel?.content)

}