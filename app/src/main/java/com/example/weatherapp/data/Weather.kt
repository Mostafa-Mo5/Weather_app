package com.example.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Weather (
    @SerializedName("id") val id :Long? ,
    @SerializedName("main") val main :String?,
    @SerializedName("description") val description :String?,

)
