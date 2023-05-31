package com.example.homework2_android3.data.remote.apiservices

import com.example.homework2_android3.models.EpisodeModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun fetchEpisode(
        @Query("page") page: Int
    ): RickAndMortyResponse<EpisodeModel>

    @GET("api/episode/{id}")
    fun fetchIdEpisode(
        @Path("id") id: Int
    ): Call<EpisodeModel>
}
