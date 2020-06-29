package com.example.internshiptestfathan.data.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.internshiptestfathan.data.DB_NAME
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel
import com.example.internshiptestfathan.menu.list.models.response.PlaceResponseModel

@TypeConverters(Converter::class)
@Database(entities = [GalleryModel::class, PlaceResponseModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun galleryDaoAccess():GalleryDaoAccess
    abstract fun placeDaoAccess():PlaceDaoAccess

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = create(context)
            }
            return instance
        }

        private fun create(context: Context): AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
        }
    }

}