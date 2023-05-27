package com.example.homework2_android3.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.homework2_android3.App
import com.example.homework2_android3.data.repository.pagingsources.LocationPagingSources
import com.example.homework2_android3.models.LocationModel
import kotlinx.coroutines.flow.Flow

class LocationRepository {

    fun fetchLocation(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LocationPagingSources(App.locationApiService!!)
            }
        ).flow
    }
}