package com.example.homework2_android3

import android.app.Application
import com.example.homework2_android3.data.RetrofitClient
import com.example.homework2_android3.data.remote.CharacterApiService

class App : Application() {

    companion object {
        var characterApi: CharacterApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitClient = RetrofitClient( )
        characterApi = retrofitClient.provideCharacterApiService()
    }
}