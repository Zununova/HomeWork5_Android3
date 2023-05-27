package com.example.homework2_android3.data.remote.apiservices

import com.example.homework2_android3.models.LocationModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    fun fetchLocation(
        @Query("page") page: Int
    ): RickAndMortyResponse<LocationModel>
}