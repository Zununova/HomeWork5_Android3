package com.example.homework2_android3

import android.app.Application
import com.example.homework2_android3.data.remote.RetrofitClient
import com.example.homework2_android3.data.remote.apiservices.CharacterApiService
import com.example.homework2_android3.data.remote.apiservices.EpisodeApiService
import com.example.homework2_android3.data.remote.apiservices.LocationApiService

class App : Application() {

    companion object {
        var characterApi: CharacterApiService? = null
        var locationApiService: LocationApiService? = null
        var episodeApiService: EpisodeApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitClient = RetrofitClient()
        characterApi = retrofitClient.provideCharacterApiService()
        locationApiService = retrofitClient.provideLocationApiService()
        episodeApiService = retrofitClient.provideEpisodeApiService()
    }
}