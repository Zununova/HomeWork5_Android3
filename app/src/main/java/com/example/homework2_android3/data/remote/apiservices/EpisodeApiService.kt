package com.example.homework2_android3.data.remote.apiservices

import com.example.homework2_android3.models.EpisodeModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisode(
        @Query("page") page: Int
    ): RickAndMortyResponse<EpisodeModel>
}