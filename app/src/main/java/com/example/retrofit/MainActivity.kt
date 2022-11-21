package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView


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
        var citys = arrayOf(" ","Alto Paraíso", "Maringá", "Icaraíma")
        var spinner = findViewById<Spinner>(R.id.spinner1)
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, citys)

    }
}