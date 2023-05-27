package com.example.homework2_android3.ui.fragments.character

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework2_android3.R
import com.example.homework2_android3.baseFragment.BaseFragment
import com.example.homework2_android3.databinding.FragmentCharacterBinding
import com.example.homework2_android3.ui.adapters.CharacterAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    private val characterAdapter = CharacterAdapter()

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        binding.characterRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserves() {
        super.setupObserves()

        lifecycleScope.launch {
            viewModel.fetchCharacters().collect{
                characterAdapter.submitData(it)
            }
        }
    }
}