package com.example.homework2_android3.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework2_android3.App
import com.example.homework2_android3.models.EpisodeModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeViewModel : ViewModel() {

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>?> {
        val data = MutableLiveData<RickAndMortyResponse<EpisodeModel>?>()

        App.episodeApiService?.fetchEpisode()
            ?.enqueue(object : Callback<RickAndMortyResponse<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    response: Response<RickAndMortyResponse<EpisodeModel>>
                ) {
                    if (response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}