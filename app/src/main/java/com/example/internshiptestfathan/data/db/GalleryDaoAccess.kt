package com.example.internshiptestfathan.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel

@Dao
interface GalleryDaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGallery(galleryModel: GalleryModel)

    @Query("SELECT * FROM galleries")
    fun galleries(): MutableList<GalleryModel>
}