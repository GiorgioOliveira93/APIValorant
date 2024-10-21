package com.giorgio.apivalorant.ui.Screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giorgio.apivalorant.model.Responses.Data
import com.giorgio.apivalorant.model.Responses.ModelValorant
import com.giorgio.apivalorant.model.ValorantRespository
import kotlinx.coroutines.launch

class DetalhesScreenViewModel():ViewModel() {

    private val Detalhesrespository = ValorantRespository()

    private val _valorantAgents = MutableLiveData<List<Data>>()
    val valorantAgents: LiveData<List<Data>> = _valorantAgents

    fun fetDetalhesValorantAgents(){
        viewModelScope.launch {
            try {
                val agents = Detalhesrespository.getDetalhesValorant().data
                _valorantAgents.value = agents
            }catch (e: Exception){
                Log.d("EXC", "fetValorantAgents: ${e.message.toString()}")
            }
        }
    }
}