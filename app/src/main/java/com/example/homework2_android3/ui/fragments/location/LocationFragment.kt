package com.example.homework2_android3.ui.fragments.location


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework2_android3.R
import com.example.homework2_android3.baseFragment.BaseFragment
import com.example.homework2_android3.databinding.FragmentLocationBinding
import com.example.homework2_android3.ui.activity.MainActivity
import com.example.homework2_android3.ui.adapters.LocationAdapter
import kotlinx.coroutines.launch

class LocationFragment :
    BaseFragment<FragmentLocationBinding, LocationSharedViewModel>(R.layout.fragment_location) {

    private val locationAdapter = LocationAdapter(this::onItemCLick)

    private fun onItemCLick(id: Int) {
        findNavController().navigate(
            LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(id)
        )
    }

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationSharedViewModel by viewModels()

    override fun initialize() {
        binding.locationRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupListener() {
        super.setupListener()
        bottomNavigationSelected()
    }

    override fun setupObserves() {
        super.setupObserves()

        lifecycleScope.launch {
            viewModel.fetchLocation().collect {
                locationAdapter.submitData(it)
            }
        }
    }

    override fun bottomNavigationSelected() {
        super.bottomNavigationSelected()
        (requireActivity() as MainActivity).setOnItemReselectedListener {
            binding.locationRecyclerView.smoothScrollToPosition(0)
        }
    }
}