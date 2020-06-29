package com.example.internshiptestfathan.menu.list.models.response

import androidx.annotation.Keep
import androidx.room.*
import com.example.internshiptestfathan.menu.list.models.HeaderModel
import com.example.internshiptestfathan.menu.list.models.PlaceModel

@Keep
@Entity(tableName = "placeResps")
@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
class PlaceResponseModel (
    @Embedded(prefix = "placeResp_header") @PrimaryKey val header: HeaderModel,
    val content: MutableList<PlaceModel>?
)