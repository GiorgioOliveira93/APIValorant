package com.giorgio.apivalorant.Network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ValorantApi {
    private const val BASE_URL = "https://valorant-api.com/v1/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val valorantApiService: ValorantService by lazy {
        retrofit.create(ValorantService::class.java)
    }
}