package com.example.homework2_android3.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.homework2_android3.App
import com.example.homework2_android3.data.repository.pagingsources.LocationPagingSources
import com.example.homework2_android3.models.LocationModel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {

    fun fetchLocation(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 2,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LocationPagingSources(App.locationApiService!!)
            }
        ).flow
    }

    fun fetchSingleLocation(id: Int): Flow<LocationModel?> = callbackFlow {
        val callback = object : Callback<LocationModel> {
            override fun onResponse(
                call: Call<LocationModel>,
                response: Response<LocationModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    trySend(response.body()).isSuccess
                } else {
                    trySend(null).isSuccess
                }
            }

            override fun onFailure(call: Call<LocationModel>, t: Throwable) {
                trySend(null).isSuccess
                Log.e("error", t.localizedMessage ?: "Error")
            }
        }

        App.locationApiService?.fetchIdLocation(id)?.enqueue(callback)

        awaitClose {

        }
    }
}