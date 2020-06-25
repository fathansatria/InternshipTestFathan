package com.example.internshiptestfathan.menu.list.models.response

import androidx.annotation.Keep
import com.example.internshiptestfathan.menu.list.models.HeaderModel
import com.example.internshiptestfathan.menu.list.models.PlaceModel

@Keep
class PlaceResponseModel (
    val header: HeaderModel?,
    val content: MutableList<PlaceModel>?
)