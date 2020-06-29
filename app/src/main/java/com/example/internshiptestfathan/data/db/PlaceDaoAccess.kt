package com.example.internshiptestfathan.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.internshiptestfathan.menu.list.models.response.PlaceResponseModel

@Dao
interface PlaceDaoAccess {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlace(placeResponseModel: PlaceResponseModel?)

    @Query("SELECT * FROM placeResps")
    fun placeResponses(): PlaceResponseModel
}