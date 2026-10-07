package com.practicum.playlist_maker_android_sazonenkodmitriy.ui.search


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.model.Track


@Composable
fun DetailsScreen(track: Track) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x37, 0x72, 0xE7))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Детали трека",
            //color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = "Track icon",
            modifier = Modifier.size(100.dp),
            tint = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = track.trackName,
            //color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Исполнитель: ${track.artistName}",
            //color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}
@Preview(showBackground = true, locale = "ru")
@Composable
fun DetailsScreenPreview() {
    val track = Track(1, "Yesterday (Remastered 2009)", "The Beatles", trackTime = "6:07")
    DetailsScreen(track = track)
}