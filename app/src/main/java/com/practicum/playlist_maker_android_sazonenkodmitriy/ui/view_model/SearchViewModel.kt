package com.practicum.playlist_maker_android_sazonenkodmitriy.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.practicum.playlist_maker_android_sazonenkodmitriy.App
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.api.TracksRepository
import com.practicum.playlist_maker_android_sazonenkodmitriy.domain.model.Track
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class SearchState {
    object Initial: SearchState()

    // начало и конец поиска
    object Searching: SearchState()
    data class Success(val foundList: List<Track>): SearchState()

    data class Fail(val error: String): SearchState()
}

class SearchViewModel(
    private val trackRepository: TracksRepository
) : ViewModel() {
    private val _searchScreenState = MutableStateFlow<SearchState>(SearchState.Initial)
    val searchScreenState = _searchScreenState.asStateFlow()

    fun searchTracks(query: String) {
        viewModelScope.launch {
            _searchScreenState.value = SearchState.Searching
            try {
                val result = trackRepository.searchTracksContains(query)
                if (result.isNotEmpty()) {
                    _searchScreenState.value = SearchState.Success(result)
                } else {
                    _searchScreenState.value = SearchState.Fail("Ничего не найдено")
                }
            } catch (e: Exception) {
                _searchScreenState.value = SearchState.Fail("Ошибка при поиске: ${e.message}")
            }
        }
    }

    fun clearSearch() {
        _searchScreenState.value = SearchState.Initial
    }
}