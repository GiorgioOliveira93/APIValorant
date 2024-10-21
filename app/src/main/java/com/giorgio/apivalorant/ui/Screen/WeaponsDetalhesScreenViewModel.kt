package com.giorgio.apivalorant.ui.Screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giorgio.apivalorant.model.Responses.Data
import com.giorgio.apivalorant.model.ValorantRespository
import kotlinx.coroutines.launch

class WeaponsDetalhesScreenViewModel(): ViewModel() {

    private val Detalhesrespository = ValorantRespository()

    private val _valorantWeapons = MutableLiveData<List<com.giorgio.apivalorant.model.WeponsApi.Data>>()
    val valorantWeapons: LiveData<List<com.giorgio.apivalorant.model.WeponsApi.Data>> = _valorantWeapons

    fun fetDetalhesValorantAgents(){
        viewModelScope.launch {
            try {
                val agents = Detalhesrespository.getWeapons().data
                _valorantWeapons.value = agents
            }catch (e: Exception){
                Log.d("EXC", "fetValorantAgents: ${e.message.toString()}")
            }
        }
    }

}