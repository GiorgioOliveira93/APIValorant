package com.giorgio.apivalorant.ui.Screen

import android.graphics.Color.parseColor
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

val String.color
    get() = Color(parseColor(this))

@Composable
fun DetalhesScreen(
    navController: NavController,
    uuid: String? = "asda",
    viewModel: DetalhesScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

) {

    val valorantCards by viewModel.valorantAgents.observeAsState(null)
    val filterElement = valorantCards?.filter { it.uuid == uuid }
    var expandableList by remember { mutableStateOf(false) }

    if (filterElement.isNullOrEmpty()){
        CircularProgressIndicator() }
    if (filterElement != null) {
        filterElement.forEach { agentsValorantFilter ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .height(300.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Text(
                        text = agentsValorantFilter.displayName,
                        color = Color.Blue,
                        style = TextStyle(fontSize = 50.sp, shadow = Shadow(color = Color.Red))
                    )
                    Row() {
                        Box() {
                            AsyncImage(
                                model = agentsValorantFilter.background,
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(color = Color.Red)
                            )
                            AsyncImage(
                                model = agentsValorantFilter.fullPortrait,
                                contentDescription = "",
                                modifier = Modifier.size(500.dp)
                            )
                        }
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 70.dp),
                        border = CardDefaults.outlinedCardBorder(true)

                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Descrição",
                                color = Color.Black,
                            )
                            Text(
                                text = agentsValorantFilter.description,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(8.dp)

                            )

                        }
                    }
                    Row {
                        Text(
                            color = Color.White,
                            text = "Habilidades",
                        )
                        Icon(
                            imageVector = if (expandableList) {
                                Icons.Default.KeyboardArrowDown
                            } else {
                                Icons.Default.KeyboardArrowUp
                            }, contentDescription = "",
                            modifier = Modifier.clickable { expandableList = !expandableList })
                        Log.d("ex", "DetalhesScreen: $expandableList")
                    }
                    if (expandableList) {
                        LazyColumn() {
                            items(agentsValorantFilter.abilities) { abilidades ->
                                Card(modifier = Modifier.padding(16.dp)) {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(16.dp)
                                    ) {
                                        AsyncImage(
                                            model = abilidades.displayIcon,
                                            contentDescription = "",
                                            modifier = Modifier
                                                .background(Color.LightGray)
                                                .size(50.dp)

                                        )
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier.padding(16.dp)
                                        ) {

                                            Text(
                                                text = abilidades.displayName,
                                                color = Color.White,
                                            )
                                            Text(
                                                text = abilidades.description,
                                                color = Color.White,

                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    LaunchedEffect(Unit) {
        viewModel.fetDetalhesValorantAgents()
    }


}



