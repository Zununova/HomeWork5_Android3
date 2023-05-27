package com.example.homework2_android3.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.homework2_android3.App
import com.example.homework2_android3.data.repository.pagingsources.CharacterPagingSources
import com.example.homework2_android3.models.CharacterModel
import kotlinx.coroutines.flow.Flow

class CharacterRepository {

    fun fetchCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSources(App.characterApi!!)
            }
        ).flow
    }
}