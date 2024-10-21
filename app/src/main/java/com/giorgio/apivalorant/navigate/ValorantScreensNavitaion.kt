package com.giorgio.apivalorant.navigate

enum class ValorantScreensNavitaion {
    AgentsValorantScreen,
    DetalhesScreen,
    MainScreen,
    MenuScreem,
    WeaponsScreen,
    WeaponsDetalhesScreen;


    companion object{
        fun FromRoute(route: String): ValorantScreensNavitaion
        = when(route?.substringBefore("/")){
            AgentsValorantScreen.name -> AgentsValorantScreen
            DetalhesScreen.name -> DetalhesScreen
            WeaponsScreen.name -> WeaponsScreen
            MenuScreem.name -> MenuScreem
            MainScreen.name -> MainScreen
            WeaponsDetalhesScreen.name -> WeaponsDetalhesScreen
            null -> AgentsValorantScreen
            else -> throw IllegalArgumentException( "Route $route is no recognized")
        }
    }
}