package com.example.homework2_android3.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework2_android3.R
import com.example.homework2_android3.baseFragment.BaseFragment
import com.example.homework2_android3.databinding.FragmentEpisodeBinding
import com.example.homework2_android3.ui.activity.MainActivity
import com.example.homework2_android3.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.launch

class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeSharedViewModel>(R.layout.fragment_episode) {

    private val episodeAdapter = EpisodeAdapter(this::onItemCLick)

    private fun onItemCLick(id: Int) {
        findNavController().navigate(
            EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(id)
        )
    }

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeSharedViewModel by viewModels()

    override fun initialize() {
        binding.episodeRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupListener() {
        super.setupListener()
        bottomNavigationSelected()
    }

    override fun setupObserves() {
        super.setupObserves()

        lifecycleScope.launch {
            viewModel.fetchEpisode().collect {
                episodeAdapter.submitData(it)
            }
        }
    }

    override fun bottomNavigationSelected() {
        super.bottomNavigationSelected()
        (requireActivity() as MainActivity).setOnItemReselectedListener {
            binding.episodeRecyclerView.smoothScrollToPosition(0)
        }
    }
}