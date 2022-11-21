package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.retrofit.api.Endpoint
import com.example.retrofit.api.ResponseWeather
import com.example.retrofit.network.NetworkUtils
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    lateinit var seletor: Spinner
    lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.textview)
        seletor = findViewById(R.id.spinner1)
        botao = findViewById(R.id.butoon)
        var citiesMap = HashMap<Int, Int>()
        citiesMap.put(1, 455918)
        citiesMap.put(2, 455883)
        citiesMap.put(3, 456227)

        var citys = arrayOf(" ","Umuarama", "Maringá", "Icaraíma", "Havana")
        var spinner = findViewById<Spinner>(R.id.spinner1)
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, citys)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.i("API", position.toString());
                var cityId = citiesMap.get(position)
                if (cityId != null) {
                    getData(cityId)
                }
            }

        }
    }

    fun getData(cityId: Int) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://api.hgbrasil.com")
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getWeather(cityId)
        var descriptionView = findViewById<TextView>(R.id.description)
        var temperatureView = findViewById<TextView>(R.id.temperature)
        var humityView = findViewById<TextView>(R.id.humitity)
        callback.enqueue(object : Callback<ResponseWeather> {
            override fun onFailure(call: Call<ResponseWeather>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseWeather>, response: Response<ResponseWeather>) {
                var data = response.body()?.result
                var temperature = data?.temp
                var description = data?.description
                var humity = data?.humidity
                humityView.text = humity.toString()
                temperatureView.text = temperature.toString()
                descriptionView.text = description.toString()

            }
        })

    }
}