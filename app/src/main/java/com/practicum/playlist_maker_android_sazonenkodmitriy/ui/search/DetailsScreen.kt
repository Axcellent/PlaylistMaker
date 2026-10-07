package com.practicum.playlist_maker_android_sazonenkodmitriy.ui.search


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practicum.playlist_maker_android_sazonenkodmitriy.R
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.model.Track


@Composable
fun DetailsScreen(track: Track) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.details_track_name),
            color = colorResource(R.color.main_text),
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = colorResource(R.color.fg_secondary),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = track.trackName,
            color = colorResource(R.color.main_text),
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "${stringResource(R.string.details_track_author)}: ${track.artistName}",
            color = colorResource(R.color.main_text),
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