package com.example.homework2_android3.ui.fragments.location

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
import com.example.homework2_android3.databinding.FragmentLocationBinding
import com.example.homework2_android3.ui.adapters.LocationAdapter
import kotlinx.coroutines.launch

class LocationFragment :
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    private val locationAdapter = LocationAdapter()

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()

    override fun initialize() {
        binding.locationRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObserves() {
        super.setupObserves()

        lifecycleScope.launch {
            viewModel.fetchLocation().collect{
                locationAdapter.submitData(it)
            }
        }
    }
}