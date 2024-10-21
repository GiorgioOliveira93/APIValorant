package com.giorgio.apivalorant.navigate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.giorgio.apivalorant.ui.Screen.AgentsValorantScreen
import com.giorgio.apivalorant.ui.Screen.DetalhesScreen
import com.giorgio.apivalorant.ui.Screen.MenuScreem
import com.giorgio.apivalorant.ui.Screen.WeaponsDetalhesScreen
import com.giorgio.apivalorant.ui.Screen.WeaponsScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValorantScreensNavitaionfun() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Scaffold(
            bottomBar = {
                BottomNavigation() {
                    BottomNavigationItem(
                        label = { Text(text = "Agentes") },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = ""
                            )
                        },
                        selected = true,
                        onClick = { navController.navigate(ValorantScreensNavitaion.AgentsValorantScreen.name) })
                    BottomNavigationItem(
                        label = { Text(text = "Weapons") },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = ""
                            )
                        },
                        selected = true,
                        onClick = { navController.navigate(ValorantScreensNavitaion.WeaponsScreen.name) })
                    BottomNavigationItem(
                        label = { Text(text = "Versão") },
                        icon = { Icon(imageVector = Icons.Default.Menu, contentDescription = "") },
                        selected = true,
                        onClick = { navController.navigate(ValorantScreensNavitaion.MenuScreem.name) })
                }
            }
        ) { contentPadding ->
            Box(modifier = Modifier.padding(contentPadding))
            NavHost(
                navController = navController,
                startDestination = ValorantScreensNavitaion.AgentsValorantScreen.name
            ) {
                composable(
                    route = ValorantScreensNavitaion.AgentsValorantScreen.name
                ) {
                    AgentsValorantScreen(navController)
                }
                composable(
                    route = ValorantScreensNavitaion.DetalhesScreen.name + "/{uuid}",
                    arguments = listOf(
                        navArgument("uuid") {
                            type = NavType.StringType
                            nullable = true
                        },
                    )
                ) {
                    DetalhesScreen(
                        navController = navController,
                        uuid = it.arguments?.getString("uuid"),
                    )
                }
                composable(route = ValorantScreensNavitaion.WeaponsScreen.name) {
                    WeaponsScreen(navController = navController)
                }
                composable(route = ValorantScreensNavitaion.MenuScreem.name) {
                    MenuScreem(navController = navController)
                }
                composable(
                    route = ValorantScreensNavitaion.WeaponsDetalhesScreen.name + "/{uuid}",
                    arguments = listOf(
                    navArgument("uuid"){
                        type = NavType.StringType
                        nullable = true
                    }
                ) ){
                    WeaponsDetalhesScreen(navController = navController, uuid = it.arguments?.getString("uuid"))

                }

            }
        }
    }
}