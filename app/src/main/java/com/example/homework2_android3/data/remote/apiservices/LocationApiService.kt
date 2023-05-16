package com.example.homework2_android3.data.remote.apiservices

import com.example.homework2_android3.models.LocationModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationModel>>

}