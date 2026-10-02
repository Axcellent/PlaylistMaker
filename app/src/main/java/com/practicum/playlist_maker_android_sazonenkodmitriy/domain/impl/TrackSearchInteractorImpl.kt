package com.practicum.playlist_maker_android_sazonenkodmitriy.domain.impl

import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api.TrackSearchInteractor
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api.TracksRepository
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.model.Track

class TrackSearchInteractorImpl(private val repository: TracksRepository) : TrackSearchInteractor {

    override fun searchTracks(expression: String): List<Track> {
        return repository.searchTracks(expression)
    }
}