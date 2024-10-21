package com.giorgio.apivalorant.model

import com.giorgio.apivalorant.Network.api.ValorantApi
import com.giorgio.apivalorant.model.Responses.Data
import com.giorgio.apivalorant.model.Responses.ModelValorant
import com.giorgio.apivalorant.model.WeponsApi.Weapons


class ValorantRespository() {
    private val valorantAgentsRepo = ValorantApi.valorantApiService

    suspend fun getValorantCards(): ModelValorant{
        return valorantAgentsRepo.getCreditCars()
    }

    suspend fun getDetalhesValorant(): ModelValorant {
        return valorantAgentsRepo.getCreditCars()
    }

    suspend fun getWeapons(): Weapons{
        return valorantAgentsRepo.getweapons()
    }

}