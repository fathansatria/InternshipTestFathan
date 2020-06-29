package com.example.internshiptestfathan.data.db

import android.content.Context
import android.os.AsyncTask
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel

class DbGalleryRepository(context: Context) {

    private val dbGallery = AppDatabase.getInstance(context)?.galleryDaoAccess()

    fun insertGalleries(galleryModel : GalleryModel) {
        AsyncTask.execute { dbGallery?.insertGallery(galleryModel) }
    }

    fun getGalleries(galleries:(MutableList<GalleryModel>?) -> Unit) {
        return AsyncTask.execute{galleries(dbGallery?.galleries())}
    }
}