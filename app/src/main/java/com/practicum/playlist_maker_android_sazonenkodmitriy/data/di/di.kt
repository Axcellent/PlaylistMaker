package com.practicum.playlist_maker_android_sazonenkodmitriy.data.di

import com.practicum.playlist_maker_android_sazonenkodmitriy.data.NetworkClient
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.TracksRepositoryImpl
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.network.RetrofitNetworkClient
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api.TracksRepository
import okhttp3.internal.platform.android.AndroidSocketAdapter.Companion.factory
import org.koin.dsl.module


val repositoryModule = module {
    factory<NetworkClient> {
        RetrofitNetworkClient()
    }
    factory<TracksRepository> {
        TracksRepositoryImpl(get())
    }
}