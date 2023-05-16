package com.example.homework2_android3.ui.fragments.episode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework2_android3.databinding.FragmentEpisodeBinding
import com.example.homework2_android3.ui.adapters.EpisodeAdapter

class EpisodeFragment : Fragment() {

    private lateinit var binding: FragmentEpisodeBinding
    private val episodeAdapter = EpisodeAdapter()
    private var viewModel: EpisodeViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[EpisodeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpObserves()
    }

    private fun initialize() {
        binding.episodeRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    private fun setUpObserves() {
        viewModel?.fetchEpisode()?.observe(viewLifecycleOwner) {
            episodeAdapter.submitList(it?.results)
        }
    }
}