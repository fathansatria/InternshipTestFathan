package com.example.internshiptestfathan.network.basemodels

import androidx.annotation.Keep

@Keep
class ApiServiceModelList<T> (
    val status_code: Int?,
    val message: String?,
    val data: MutableList<T>
)