package com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api

import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.model.Track

interface TracksRepository {
    fun searchTracks(expression: String): List<Track>
    suspend fun searchTracksContains(expression: String): List<Track>
    suspend fun loadTrackDetail(trackId: Long): Track
}