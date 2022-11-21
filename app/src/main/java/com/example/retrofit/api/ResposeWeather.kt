package com.example.retrofit.api

import com.google.gson.annotations.SerializedName

data class ResponseWeather (@SerializedName("results") val result: Weather)