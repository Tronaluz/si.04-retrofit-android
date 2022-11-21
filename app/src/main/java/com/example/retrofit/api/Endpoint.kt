package com.example.retrofit.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {
    @GET("weather")
    fun getWeather(@Query("woeid") cityId: Int): Call<ResponseWeather>;
}