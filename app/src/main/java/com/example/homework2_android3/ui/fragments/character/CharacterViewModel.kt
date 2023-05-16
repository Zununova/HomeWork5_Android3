package com.example.homework2_android3.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework2_android3.App
import com.example.homework2_android3.models.CharacterModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    fun fetchCharacters(): MutableLiveData<RickAndMortyResponse<CharacterModel>?> {
        val data = MutableLiveData<RickAndMortyResponse<CharacterModel>?>()

        App.characterApi?.fetchCharacters()
            ?.enqueue(object : Callback<RickAndMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    if (response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}