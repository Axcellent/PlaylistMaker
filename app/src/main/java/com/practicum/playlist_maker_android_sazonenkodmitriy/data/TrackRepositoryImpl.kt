package com.practicum.playlist_maker_android_sazonenkodmitriy.data

import com.practicum.playlist_maker_android_sazonenkodmitriy.data.dto.TracksSearchRequest
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.dto.TracksSearchResponse
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api.TracksRepository
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.model.Track

class TracksRepositoryImpl(private val networkClient: NetworkClient) : TracksRepository {

    override fun searchTracks(expression: String): List<Track> {
        val response = networkClient.doRequest(TracksSearchRequest(expression))

        if (response.resultCode == 200) { // успешный запрос
            return (response as TracksSearchResponse).results.map {
                val seconds = it.trackTimeMillis / 1000
                val minutes = seconds / 60
                val trackTime = "%02d".format(minutes) + ":" + "%02d".format(seconds - minutes * 60)

                Track(it.id, it.trackName, it.artistName, trackTime)
            }
        }

        return emptyList()
    }
}