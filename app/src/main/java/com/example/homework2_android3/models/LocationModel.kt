package com.example.homework2_android3.models

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String

)
