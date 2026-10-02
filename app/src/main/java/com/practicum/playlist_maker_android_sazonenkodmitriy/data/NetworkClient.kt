package com.practicum.playlist_maker_android_sazonenkodmitriy.data

import com.practicum.playlist_maker_android_sazonenkodmitriy.data.dto.BaseResponse

interface NetworkClient {
    fun doRequest(dto: Any): BaseResponse
}