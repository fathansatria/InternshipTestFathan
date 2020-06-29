package com.example.internshiptestfathan.menu.list.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "header")
data class HeaderModel(
    @ColumnInfo(name ="title") @PrimaryKey val title : String,
    @ColumnInfo(name ="subtitle") val subtitle : String
)