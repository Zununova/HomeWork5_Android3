package com.example.homework2_android3.ui.fragments.character.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.homework2_android3.R
import com.example.homework2_android3.baseFragment.BaseFragment
import com.example.homework2_android3.databinding.FragmentCharacterDetailBinding
import com.example.homework2_android3.ui.fragments.character.CharacterSharedViewModel
import kotlinx.coroutines.launch

class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding, CharacterSharedViewModel>(R.layout.fragment_character_detail) {

    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    override val viewModel: CharacterSharedViewModel by viewModels()

    override fun setupObserves() {
        super.setupObserves()
        val args by navArgs<CharacterDetailFragmentArgs>()
        lifecycleScope.launch {
            viewModel.fetchIdCharacter(args.id).collect {
                binding.characterDetailNameTextView.text = it?.name
                Glide.with(binding.characterDetailImageView).load(it?.image)
                    .into(binding.characterDetailImageView)
            }
        }
    }
}