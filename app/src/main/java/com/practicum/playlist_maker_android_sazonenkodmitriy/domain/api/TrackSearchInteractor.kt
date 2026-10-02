package com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api

import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.model.Track

interface TrackSearchInteractor {
    fun searchTracks(expression: String): List<Track>
}