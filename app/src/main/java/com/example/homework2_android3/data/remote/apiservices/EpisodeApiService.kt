package com.example.homework2_android3.data.remote.apiservices

import com.example.homework2_android3.models.EpisodeModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>

}