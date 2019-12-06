package com.ejemploapp2.pmdm_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

//CADA ESTRELLA ES UN BOTÓN CON EL QUE SE ACCEDE A UNA ACTIVIDAD NUEVA
//NECESITAMOS SABER MEDIANTE UNA VARIANBLE SI LA ACTIVIDAD QUE HEMOS VISITADO SE HA COMPLETADO CORRECTAMENTE
//O NO, SI ES EL CASO PUES EL BOTÓN CAMBIARÁ DE COLOR

//VARIABLES GLOBALES:
const val INTERNET_REQUEST = 1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPrueba1.setOnClickListener{accesoRetoInternet()}

        toast("BIENVENIDO :D")

    }

    fun accesoRetoInternet() {

        val miIntent = Intent(this, RetoInternet::class.java)

        //variable para saber si se ha completado el reto ( 0 --> no  1 --> sí)
        val comprueba = 0

        miIntent.putExtra("comprueba", comprueba)

        startActivityForResult(miIntent, INTERNET_REQUEST)

    }


}
