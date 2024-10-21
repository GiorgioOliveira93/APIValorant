package com.giorgio.apivalorant.ui.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.giorgio.apivalorant.Components.Hexagon
import com.giorgio.apivalorant.model.WeponsApi.Weapons
import com.giorgio.apivalorant.navigate.ValorantScreensNavitaion

@Composable
fun AgentsValorantScreen(
    navController: NavController,
    viewModel: AgentsValorantViewModel = viewModel()
) {
    val valorantCards by viewModel.valorantAgents.observeAsState(null)
    val overlap = (-70).dp
    LaunchedEffect(Unit) {
        viewModel.fetValorantAgents()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (valorantCards == null) {
            CircularProgressIndicator()
        } else {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(overlap),
            ) {
                itemsIndexed(valorantCards!!.data) { index, valorantCards ->
                    Hexagon(
                        text = valorantCards.displayName,
                        Image = valorantCards.displayIcon,
                        hexagonSize = 200.dp,
                        index = index,
                    ) {
                        val route =
                            ValorantScreensNavitaion.DetalhesScreen.name + "/${valorantCards.uuid}"
                        navController.navigate(
                            route
                        )
                    }
                }
            }
        }


    }
}

@Composable
fun CreditCardItem(
    navController: NavController,
    name: String,
    description: String,
    displayIcon: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(model = displayIcon, contentDescription = "")

        }
    }
}
