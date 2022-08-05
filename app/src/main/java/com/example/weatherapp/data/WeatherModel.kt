package com.example.weatherapp.data

import com.example.okhttp.data.Sys
import com.example.okhttp.data.Wind
import com.google.gson.annotations.SerializedName

data class WeatherModel (
    @SerializedName("name") val name : String?,
    @SerializedName("weather") val weather :List<Weather>?,
    @SerializedName("main") val main : Main?,
    @SerializedName("wind") val wind : Wind?,
    @SerializedName("sys") val country: Sys?
        )