package com.example.internshiptestfathan.menu.list.models

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class PlaceModel(
    val id: Int?,
    val title: String?,
    val content: String?,
    val type: String?,
    val image: String?,
    val media: MutableList<String?>?
): Parcelable