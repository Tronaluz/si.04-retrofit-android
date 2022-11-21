package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofit.api.Endpoint
import com.example.retrofit.api.ResponseWeather
import com.example.retrofit.api.Weather
import com.example.retrofit.network.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://api.hgbrasil.com")
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getWeather(455918)
        callback.enqueue(object : Callback<ResponseWeather> {
            override fun onFailure(call: Call<ResponseWeather>, t: Throwable) {
                Log.i("API", t.toString());
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseWeather>, response: Response<ResponseWeather>) {
                Log.i("API", response.body());
            }
        })

    }
}