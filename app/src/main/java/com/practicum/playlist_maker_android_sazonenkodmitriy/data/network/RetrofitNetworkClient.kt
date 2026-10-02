package com.practicum.playlist_maker_android_sazonenkodmitriy.data.network

import com.practicum.playlist_maker_android_sazonenkodmitriy.data.NetworkClient
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.dto.BaseResponse
import com.practicum.playlist_maker_android_sazonenkodmitriy.data.dto.TracksSearchResponse
import kotlin.collections.listOf

class RetrofitNetworkClient : NetworkClient {
    override fun doRequest(dto: Any): BaseResponse {
        return TracksSearchResponse(listOf())
    }
}