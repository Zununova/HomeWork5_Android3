package com.example.homework2_android3.data.remote

import com.example.homework2_android3.models.CharacterModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApiService {
    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<CharacterModel>>

}