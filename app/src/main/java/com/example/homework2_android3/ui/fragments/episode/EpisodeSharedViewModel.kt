package com.example.homework2_android3.ui.fragments.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.homework2_android3.data.repository.EpisodeRepository

class EpisodeSharedViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()

    suspend fun fetchEpisode() = episodeRepository.fetchEpisode().cachedIn(viewModelScope)

    fun fetchIdEpisode(id: Int) = episodeRepository.fetchSingleEpisode(id)

}
