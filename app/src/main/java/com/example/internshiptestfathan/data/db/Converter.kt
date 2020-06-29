package com.example.internshiptestfathan.data.db

import androidx.room.TypeConverter
import com.example.internshiptestfathan.menu.list.models.PlaceModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromMutableList(value: MutableList<PlaceModel>?): String{
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toMutableList(value: String): MutableList<PlaceModel>{
        val mutableListType = object : TypeToken<MutableList<PlaceModel>>(){}.type
        return Gson().fromJson(value, mutableListType)
    }

    @TypeConverter
    fun toString(value: MutableList<String?>?): String{
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromString(value: String): MutableList<String?>{
        val mutableListType = object : TypeToken<MutableList<String?>?>(){}.type
        return Gson().fromJson(value, mutableListType)
    }
}