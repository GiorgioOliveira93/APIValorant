package com.giorgio.apivalorant.ui.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.giorgio.apivalorant.navigate.ValorantScreensNavitaion

@Composable
fun WeaponsScreen(
    navController: NavController,
    viewModel: WeaponsScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val ValorantWeapons by viewModel.valorantWeapons.observeAsState(null)
    LaunchedEffect(Unit) {
        viewModel.fetValorantWeapons()
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (ValorantWeapons == null) {
            CircularProgressIndicator()
        } else {
            LazyColumn()
            {
                items(ValorantWeapons!!.data) { weapons ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(150.dp)
                            .padding(16.dp),
                        border = BorderStroke(2.dp, Color.DarkGray)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = weapons.displayName)
                                Text(text = "PODER DE FOGO ${weapons.weaponStats.fireRate.toString()}")
                                Button(onClick = {
                                    val route =
                                        ValorantScreensNavitaion.WeaponsDetalhesScreen.name + "/${weapons.uuid}"
                                    navController.navigate(route)
                                }) {
                                    Text(text = "DETALHES DAS ARMAS", )
                                }

                            }
                            AsyncImage(model = weapons.displayIcon, contentDescription = "")

                        }

                    }

                }

            }
        }
    }
}