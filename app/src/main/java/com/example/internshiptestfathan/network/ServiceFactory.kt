package com.example.internshiptestfathan.network

import com.example.internshiptestfathan.BuildConfig
import com.example.internshiptestfathan.data.END_POINT
import com.example.internshiptestfathan.data.TIME_OUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ServiceFactory {

    private fun retrofitInstance(): Retrofit {

        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.callTimeout(TIME_OUT, TimeUnit.SECONDS)
        clientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        clientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS)
        clientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        clientBuilder.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(END_POINT)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(clientBuilder.build())
            .build()
    }

    fun <T> getApiService(service:Class<T>):T {
        return retrofitInstance().create(service)
    }
}