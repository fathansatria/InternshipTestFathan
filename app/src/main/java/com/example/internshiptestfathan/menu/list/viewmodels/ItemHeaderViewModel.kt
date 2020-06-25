package com.example.internshiptestfathan.menu.list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.internshiptestfathan.menu.list.models.HeaderModel

class ItemHeaderViewModel(listHeaderModel: HeaderModel): ViewModel() {
    var title: ObservableField<String?> = ObservableField(listHeaderModel.title)
    var subTitle: ObservableField<String?> = ObservableField(listHeaderModel.subtitle)
}