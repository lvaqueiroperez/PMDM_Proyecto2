package com.ejemploapp2.pmdm_proyecto2

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

//CADA ESTRELLA ES UN BOTÓN CON EL QUE SE ACCEDE A UNA ACTIVIDAD NUEVA
//NECESITAMOS SABER MEDIANTE UNA VARIANBLE SI LA ACTIVIDAD QUE HEMOS VISITADO SE HA COMPLETADO CORRECTAMENTE
//O NO, SI ES EL CASO PUES EL BOTÓN CAMBIARÁ DE COLOR

//VARIABLES GLOBALES:
const val INTERNET_REQUEST = 1
const val CAMARA_REQUEST = 2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPrueba1.setOnClickListener { accesoRetoInternet() }

        btnPrueba2.setOnClickListener { accesoRetoCamara() }

        toast("BIENVENIDO :D")

    }

    fun accesoRetoInternet() {

        val miIntent = Intent(this, RetoInternet::class.java)

        startActivityForResult(miIntent, INTERNET_REQUEST)

    }

    fun accesoRetoCamara() {

        val miIntent = Intent(this, activity_reto_camara::class.java)

        startActivityForResult(miIntent, CAMARA_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == INTERNET_REQUEST) {

            if (resultCode == Activity.RESULT_OK) {

                if (data != null) {

                    val resultado = data.getIntExtra("resultado", 0)

                    if (resultado == 1) {

                        //CAMBIAMOS LA APARIENCIA DEL BOTÓN (probamos primero con la label)
                        lblPrueba1.setTextColor(Color.GREEN)

                    }

                }

            }


        } else if (requestCode == CAMARA_REQUEST) {

            if (resultCode == Activity.RESULT_OK) {

                if (data != null) {

                    val resultado = data.getIntExtra("resultado", 0)

                    if (resultado == 1) {

                        //CAMBIAMOS LA APARIENCIA DEL BOTÓN (probamos primero con la label)
                        lblPrueba2.setTextColor(Color.GREEN)

                    }

                }

            }


        }


    }


}
