package com.example.homework2_android3.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework2_android3.App
import com.example.homework2_android3.models.LocationModel
import com.example.homework2_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationViewModel : ViewModel() {

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>?> {
        val data = MutableLiveData<RickAndMortyResponse<LocationModel>?>()

        App.locationApiService?.fetchLocation()
            ?.enqueue(object : Callback<RickAndMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>
                ) {
                    if (response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}