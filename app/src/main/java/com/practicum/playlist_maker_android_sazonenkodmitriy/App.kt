package com.practicum.playlist_maker_android_sazonenkodmitriy

import android.app.Application
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.TracksRepositoryImpl
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.di.repositoryModule
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.network.RetrofitNetworkClient
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api.TrackSearchInteractor
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api.TracksRepository
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.impl.TrackSearchInteractorImpl
import com.practicum.playlist_maker_android_sazonenkodmitriy.ui.view_model.SearchViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            val viewModelModule = module {
                viewModel {
                    SearchViewModel(get())
                }
            }
            modules(repositoryModule, viewModelModule)
        }
    }
}