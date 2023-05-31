package com.example.homework2_android3.data.remote.apiservices

import com.example.homework2_android3.models.LocationModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchLocation(
        @Query("page") page: Int
    ): RickAndMortyResponse<LocationModel>

    @GET("api/location/{id}")
    fun fetchIdLocation(
        @Path("id") id: Int
    ): Call<LocationModel>

}