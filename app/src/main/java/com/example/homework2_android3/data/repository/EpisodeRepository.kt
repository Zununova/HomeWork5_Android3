package com.example.homework2_android3.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.homework2_android3.App
import com.example.homework2_android3.data.repository.pagingsources.EpisodePagingSources
import com.example.homework2_android3.models.EpisodeModel
import kotlinx.coroutines.flow.Flow


class EpisodeRepository {

    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EpisodePagingSources(App.episodeApiService!!)
            }
        ).flow
    }
}