package com.giorgio.apivalorant.Network.api

import com.giorgio.apivalorant.model.Responses.Data
import com.giorgio.apivalorant.model.Responses.ModelValorant
import com.giorgio.apivalorant.model.WeponsApi.Weapons
import retrofit2.http.GET

interface ValorantService {
    @GET("agents")
    suspend fun getCreditCars(): ModelValorant

    @GET("weapons")
    suspend fun getweapons(): Weapons



}