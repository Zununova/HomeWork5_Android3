package com.example.homework2_android3.data.remote

import com.example.homework2_android3.data.remote.apiservices.CharacterApiService
import com.example.homework2_android3.data.remote.apiservices.EpisodeApiService
import com.example.homework2_android3.data.remote.apiservices.LocationApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService(): CharacterApiService {
        return retrofitClient.create(CharacterApiService::class.java)
    }

    fun provideLocationApiService(): LocationApiService {
        return retrofitClient.create(LocationApiService::class.java)
    }

    fun provideEpisodeApiService(): EpisodeApiService {
        return retrofitClient.create(EpisodeApiService::class.java)
    }
}