package com.example.homework2_android3.ui.fragments.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.homework2_android3.data.repository.LocationRepository

class LocationSharedViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocation() = locationRepository.fetchLocation().cachedIn(viewModelScope)

    fun fetchIdLocation(id: Int) = locationRepository.fetchSingleLocation(id)

}