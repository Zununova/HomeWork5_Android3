package com.example.homework2_android3.ui.fragments.episode.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework2_android3.R
import com.example.homework2_android3.baseFragment.BaseFragment
import com.example.homework2_android3.databinding.FragmentEpisodeDetailBinding
import com.example.homework2_android3.ui.fragments.episode.EpisodeSharedViewModel
import kotlinx.coroutines.launch

class EpisodeDetailFragment :
    BaseFragment<FragmentEpisodeDetailBinding, EpisodeSharedViewModel>(R.layout.fragment_episode_detail) {

    override val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    override val viewModel: EpisodeSharedViewModel by viewModels()

    override fun setupObserves() {
        super.setupObserves()
        val args by navArgs<EpisodeDetailFragmentArgs>()
        lifecycleScope.launch {
            viewModel.fetchIdEpisode(args.id).collect {
                binding.textViewDetailEpisodeName.text = it?.name
            }
        }
    }


}