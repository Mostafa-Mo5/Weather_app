package com.example.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Main (
    @SerializedName("temp") val temp :Float?,
    @SerializedName("pressure") val pressure:Float?,
    @SerializedName("humidity") val humidity:Float?,

        )