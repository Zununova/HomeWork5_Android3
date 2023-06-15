package com.example.homework2_android3.ui.fragments.character

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework2_android3.R
import com.example.homework2_android3.baseFragment.BaseFragment
import com.example.homework2_android3.databinding.FragmentCharacterBinding
import com.example.homework2_android3.ui.activity.MainActivity
import com.example.homework2_android3.ui.adapters.CharacterAdapter
import kotlinx.coroutines.launch

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterSharedViewModel>(R.layout.fragment_character) {

    private val characterAdapter = CharacterAdapter(this::onItemCLick)

    private fun onItemCLick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(id)
        )
    }

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterSharedViewModel by viewModels()

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
            viewModel.fetchCharacters().collect {
                Toast.makeText(requireContext(), it.toString() , Toast.LENGTH_SHORT).show()
                characterAdapter.submitData(it)
            }
        }
    }

    override fun setupListener() {
        super.setupListener()
        bottomNavigationSelected()
    }

    override fun bottomNavigationSelected() {
        super.bottomNavigationSelected()
        (requireActivity() as MainActivity).setOnItemReselectedListener {
            binding.characterRecyclerView.smoothScrollToPosition(0)
        }
    }
}