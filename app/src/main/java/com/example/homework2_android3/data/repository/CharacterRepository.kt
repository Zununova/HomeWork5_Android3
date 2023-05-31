package com.example.homework2_android3.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.homework2_android3.App
import com.example.homework2_android3.data.repository.pagingsources.CharacterPagingSources
import com.example.homework2_android3.models.CharacterModel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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


    fun fetchSingleCharacter(id: Int): Flow<CharacterModel?> = callbackFlow {
        val callback = object : Callback<CharacterModel> {
            override fun onResponse(
                call: Call<CharacterModel>,
                response: Response<CharacterModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    trySend(response.body()).isSuccess
                } else {
                    trySend(null).isSuccess
                }
            }

            override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                trySend(null).isSuccess
                Log.e("error", t.localizedMessage ?: "Error")
            }
        }

        App.characterApi?.fetchIdCharacter(id)?.enqueue(callback)

        awaitClose {

        }
    }

}


