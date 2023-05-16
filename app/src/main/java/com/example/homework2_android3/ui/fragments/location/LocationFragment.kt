package com.example.homework2_android3.ui.fragments.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework2_android3.databinding.FragmentLocationBinding
import com.example.homework2_android3.ui.adapters.LocationAdapter

class LocationFragment : Fragment() {

    private lateinit var binding: FragmentLocationBinding
    private val locationAdapter = LocationAdapter()
    private var locationViewModel: LocationViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        locationViewModel = ViewModelProvider(this)[LocationViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpObserves()
    }

    private fun initialize() {
        binding.locationRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    private fun setUpObserves() {
        locationViewModel?.fetchLocation()?.observe(viewLifecycleOwner) {
            locationAdapter.submitList(it?.results)
        }
    }
}