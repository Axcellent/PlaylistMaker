package com.practicum.playlist_maker_android_sazonenkodmitriy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.navigation.PlaylistHost
import com.practicum.playlist_maker_android_sazonenkodmitriy.R
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.view_model.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

enum class Screen {
    MAIN,
    SEARCH,
    SETTINGS
}

val mainFont = FontFamily(
    Font(R.font.ys_display_medium, FontWeight.Medium)
)

class MainActivity : ComponentActivity() {
    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaylistHost(
                modifier = Modifier,
                navController = rememberNavController(),
                gson = remember { Gson() },
                startDestination = "main",
                searchViewModel = searchViewModel
            )
        }
    }
}