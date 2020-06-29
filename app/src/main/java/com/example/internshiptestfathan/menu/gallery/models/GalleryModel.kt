package com.example.internshiptestfathan.menu.gallery.models

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
@Entity(tableName = "galleries")
data class GalleryModel(
    @ColumnInfo(name ="caption") @PrimaryKey val caption: String,
    @ColumnInfo(name ="thumbnail") val thumbnail: String?,
    @ColumnInfo(name ="image") val image: String?
): Parcelable