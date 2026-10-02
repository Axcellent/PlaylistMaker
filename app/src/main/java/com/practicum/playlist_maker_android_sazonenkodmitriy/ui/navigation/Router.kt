package com.practicum.playlist_maker_android_sazonenkodmitriy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.MainScreen
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.Screen
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.search.SearchScreen
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.settings.SettingsScreen

@Composable
fun PlaylistHost(
    modifier: Modifier = Modifier,
    startDestination: String = Screen.MAIN.name,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.MAIN.name) {
            MainScreen(
                onSearchClick = { navController.navigate(Screen.SEARCH.name) },
                onSettingsClick = { navController.navigate(Screen.SETTINGS.name) }
            )
        }
        composable(Screen.SEARCH.name) {
            SearchScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Screen.SETTINGS.name) {
            SettingsScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}