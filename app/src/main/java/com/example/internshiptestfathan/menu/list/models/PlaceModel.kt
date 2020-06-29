package com.example.internshiptestfathan.menu.list.models

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
@Entity(tableName = "places")
data class PlaceModel(
    @PrimaryKey val id: Int,
    val title: String?,
    val content: String?,
    val type: String?,
    val image: String?,
    val media: MutableList<String?>?
): Parcelable