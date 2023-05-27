package com.example.homework2_android3.ui.fragments.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.homework2_android3.App
import com.example.homework2_android3.data.repository.EpisodeRepository
import com.example.homework2_android3.data.repository.LocationRepository
import com.example.homework2_android3.models.EpisodeModel
import com.example.homework2_android3.models.LocationModel
import com.example.homework2_android3.models.RickAndMortyResponse
import kotlinx.coroutines.flow.collect
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()

    fun fetchEpisode() = episodeRepository.fetchEpisode().cachedIn(viewModelScope)
}
