package com.practicum.playlist_maker_android_sazonenkodmitriy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

enum class Screen {
    MAIN,
    SEARCH,
    SETTINGS
}

val mainFont = FontFamily(
    Font(R.font.ys_display_medium, FontWeight.Medium)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            PlaylistHost(navController = navController)
        }
    }
}

@Composable
fun MainScreen(
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.main_screen_background))
    ) {
        Text(
            text = stringResource(R.string.main_screen_name),

            color = colorResource(R.color.white),

            fontSize = 22.sp,
            fontFamily = mainFont,
            fontWeight = FontWeight.Medium,

            modifier = Modifier
                .padding(top = 4.dp, start = 16.dp, bottom = 18.dp)
                .fillMaxWidth()
                .height(48.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )

        Column(
            modifier = Modifier
                .background(
                    color = colorResource(R.color.background),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MenuItem(
                text = stringResource(R.string.main_screen_find),
                icon = Icons.Default.Search,
                onClick = onSearchClick
            )
            MenuItem(
                text = stringResource(R.string.main_screen_playlist),
                icon = Icons.Default.LibraryMusic,
                onClick = {
                    Toast.makeText(context, "Тут пока ничего", Toast.LENGTH_SHORT).show()
                }
            )
            MenuItem(
                text = stringResource(R.string.main_screen_favorite),
                icon = Icons.Default.FavoriteBorder,
                onClick = {
                    Toast.makeText(context, "Тут тоже", Toast.LENGTH_SHORT).show()
                }
            )
            MenuItem(
                text = stringResource(R.string.main_screen_settings),
                icon = Icons.Default.Settings,
                onClick = onSettingsClick
            )
        }
    }
}

@Composable
fun MenuItem(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .height(40.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,

            tint = colorResource(R.color.main_text),

            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,

            color = colorResource(R.color.main_text),

            fontSize = 22.sp,
            fontFamily = mainFont,
            fontWeight = FontWeight.Medium,

            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,

            tint = colorResource(R.color.fg_secondary),

            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(
    showBackground = true,
    locale = "en"
)
@Composable
fun PlaylistMakerScreenPreview() {
    MainScreen(onSearchClick = {}, onSettingsClick = {})
}