package com.giorgio.apivalorant.ui.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun WeaponsDetalhesScreen(
    navController: NavController,
    uuid: String? = "asda",
    viewModel: WeaponsDetalhesScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val valorantCards by viewModel.valorantWeapons.observeAsState()
    val filterElement = valorantCards?.filter { it.uuid == uuid }

    LaunchedEffect(Unit) {
        viewModel.fetDetalhesValorantAgents()
    }

    if (filterElement != null) {
        filterElement.forEach { weaponsFiltred ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(modifier = Modifier.padding(16.dp)) {
                    AsyncImage(
                        model = weaponsFiltred.displayIcon,
                        contentDescription = "",
                        modifier = Modifier.size(350.dp)
                    )
                }
                Card() {
                    Text(text = weaponsFiltred.displayName)
                    Text(text = weaponsFiltred.category)
                    Text(text = "Poder de fogo ${weaponsFiltred.weaponStats.fireRate}")

                }

            }
        }
    }
}