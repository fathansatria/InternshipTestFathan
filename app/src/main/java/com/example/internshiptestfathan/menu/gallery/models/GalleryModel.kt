package com.example.internshiptestfathan.menu.gallery.models

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class GalleryModel(
    val caption: String?,
    val thumbnail: String?,
    val image: String?
): Parcelable