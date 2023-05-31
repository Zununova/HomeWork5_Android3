package com.example.homework2_android3.ui.fragments.location.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework2_android3.R
import com.example.homework2_android3.baseFragment.BaseFragment
import com.example.homework2_android3.databinding.FragmentLocationDetailBinding
import com.example.homework2_android3.ui.fragments.location.LocationSharedViewModel
import kotlinx.coroutines.launch


class LocationDetailFragment :
    BaseFragment<FragmentLocationDetailBinding, LocationSharedViewModel>(R.layout.fragment_location_detail) {

    override val binding by viewBinding(FragmentLocationDetailBinding::bind)
    override val viewModel: LocationSharedViewModel by viewModels()

    override fun setupObserves() {
        super.setupObserves()
        val args by navArgs<LocationDetailFragmentArgs>()
        lifecycleScope.launch {
            viewModel.fetchIdLocation(args.id).collect {
                binding.textViewDetailLocationName.text = it?.name

            }
        }
    }
}