package com.example.homework2_android3.ui.fragments.episode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework2_android3.R
import com.example.homework2_android3.baseFragment.BaseFragment
import com.example.homework2_android3.databinding.FragmentEpisodeBinding
import com.example.homework2_android3.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    private val episodeAdapter = EpisodeAdapter()

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()

    override fun initialize() {
        binding.episodeRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObserves() {
        super.setupObserves()

        lifecycleScope.launch {
            viewModel.fetchEpisode().collect{
                episodeAdapter.submitData(it)
            }
        }
    }
}