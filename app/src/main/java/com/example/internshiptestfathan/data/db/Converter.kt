package com.example.internshiptestfathan.data.db

import androidx.room.TypeConverter
import com.example.internshiptestfathan.menu.list.models.PlaceModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converter {

    private val moshi = Moshi.Builder().build()
    private val type = Types.newParameterizedType(MutableList::class.java, PlaceModel::class.java)

    @TypeConverter
    fun fromMutableList(value: MutableList<PlaceModel>?): String{
        val adapter : JsonAdapter<MutableList<PlaceModel>> = moshi.adapter(type)
        val data = adapter.toJson(value)
        return data
    }

    @TypeConverter
    fun toMutableList(value: String): MutableList<PlaceModel>?{
        val adapter : JsonAdapter<MutableList<PlaceModel>> = moshi.adapter(type)
        val data : MutableList<PlaceModel>? = adapter.fromJson(value)
        return data
    }
}