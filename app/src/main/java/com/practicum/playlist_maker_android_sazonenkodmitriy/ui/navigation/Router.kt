package com.practicum.playlist_maker_android_sazonenkodmitriy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.model.Track
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.main.MainScreen
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.search.DetailsScreen
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.search.SearchScreen
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.settings.SettingsScreen
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.view_model.SearchViewModel
import kotlin.jvm.java


@Composable
fun PlaylistHost(
    modifier: Modifier = Modifier,
    startDestination: String = "main",
    navController: NavHostController,
    gson: Gson,
    searchViewModel: SearchViewModel
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = "main") {
            MainScreen(
                onSearchClick = { navController.navigate("search") },
                onSettingsClick = { navController.navigate("setting") }
            )
        }

        composable(
            route = "details/{trackJson}",
            arguments = listOf(navArgument("trackJson") { type = NavType.StringType })
        ) {
            backStackEntry ->
                val trackJson = backStackEntry.arguments?.getString("trackJson")
                val track = gson.fromJson(trackJson, Track::class.java)
                DetailsScreen(track = track)
        }

        composable(route = "search") {
            SearchScreen(
                searchViewModel = searchViewModel,
                navigateToDetailScreen = {
                    track ->
                        val trackJson = gson.toJson(track)
                        navController.navigate("details/$trackJson")
                }
            )
        }

        composable(route = "setting") {
            SettingsScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}