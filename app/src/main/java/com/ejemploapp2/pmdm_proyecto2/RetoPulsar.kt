package com.ejemploapp2.pmdm_proyecto2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_reto_pulsar.*
import org.jetbrains.anko.toast

//Reto Pulsar, donde el jugador tendrá que pulsar un botón 50 veces en menos de 10 segundos
class RetoPulsar : AppCompatActivity() {
    //contadores de pulsaciones y de tiempo
    var contP = 0

    var inicioTiempo = 0
    var finalTiempo = 0
    // ocultamos el botón de volver y ponemos los listener necesarios
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_pulsar)

        btnVolver1.setVisibility(View.INVISIBLE)

        btnPulsa.setOnClickListener { pulsaciones() }

        btnVolver1.setOnClickListener { volver() }

    }

    //Función que controla las pulsaciones del botón, siendo la primera la que inicia el tiempo y la
    //última la que lo para
    //Se comprueba si el user lo ha conseguido en menos de 10 segundos
    fun pulsaciones() {

        if (contP == 0) {

            inicioTiempo = System.currentTimeMillis().toInt()

            contP += 1


        } else if (contP == 50) {

            finalTiempo = System.currentTimeMillis().toInt()

            var totalTiempo = finalTiempo - inicioTiempo



            if (totalTiempo < 10000) {

                toast("TIEMPO: " + totalTiempo)
                toast("HAS GANADO !!!")
                btnPulsa.setEnabled(false)
                btnVolver1.setVisibility(View.VISIBLE)

                val resultado1 = 1

                val data = Intent()

                data.putExtra("resultado", resultado1)
                setResult(Activity.RESULT_OK, data)

            } else {


                toast("MALA SUERTE")
                btnPulsa.setEnabled(false)
                btnVolver1.setVisibility(View.VISIBLE)

                val resultado1 = 0

                val data = Intent()

                data.putExtra("resultado", resultado1)
                setResult(Activity.RESULT_OK, data)
            }


        } else {

            contP += 1

        }

    }

    //Función para configurar el botón de volver
    fun volver() {

        finish()

    }


}
