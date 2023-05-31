package com.example.homework2_android3.ui.fragments.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.homework2_android3.data.repository.CharacterRepository

class CharacterSharedViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacters() = characterRepository.fetchCharacters().cachedIn(viewModelScope)

    fun fetchIdCharacter(id: Int) = characterRepository.fetchSingleCharacter(id)

}





