package com.example.homework2_android3.data.remote.apiservices

import com.example.homework2_android3.models.CharacterModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int
    ): RickAndMortyResponse<CharacterModel>

    @GET("api/character/{id}")
    fun fetchIdCharacter(
        @Path("id") id: Int
    ): Call<CharacterModel>
}