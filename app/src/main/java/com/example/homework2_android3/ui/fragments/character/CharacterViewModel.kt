package com.example.homework2_android3.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.homework2_android3.App
import com.example.homework2_android3.data.repository.CharacterRepository
import com.example.homework2_android3.data.repository.LocationRepository
import com.example.homework2_android3.models.CharacterModel
import com.example.homework2_android3.models.LocationModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacters() = characterRepository.fetchCharacters().cachedIn(viewModelScope)

}