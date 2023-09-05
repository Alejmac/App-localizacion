package com.example.localizacion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val locationService:LocationService = LocationService()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvLocation = findViewById<TextView>(R.id.tVLocalitation)
        val btnLocation = findViewById<Button>(R.id.btnLocation)

        btnLocation.setOnClickListener {
            //metodo para lanzar corrutinas
            lifecycleScope.launch {
                //se lanza la localizacion a la actividad
                val result = locationService.getLocation(this@MainActivity)
                if (result != null) {
                    tvLocation.text = "Latitud  ${result.latitude}  and  Longitud ${result.longitude}"
                }

            }

        }
    }
}