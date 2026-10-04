package com.practicum.playlist_maker_android_sazonenkodmitriy

import android.app.Application
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.TracksRepositoryImpl
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.network.RetrofitNetworkClient
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api.TrackSearchInteractor
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api.TracksRepository
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.impl.TrackSearchInteractorImpl

class App : Application() {
    fun getTracksRepository(): TracksRepository {
        return TracksRepositoryImpl(RetrofitNetworkClient())
    }

    fun provideTrackSearchInteractor(): TrackSearchInteractor {
        return TrackSearchInteractorImpl(getTracksRepository())
    }
}