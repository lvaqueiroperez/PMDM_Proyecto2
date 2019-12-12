package com.ejemploapp2.pmdm_proyecto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto_pulsar.*
import org.jetbrains.anko.toast

class RetoPulsar : AppCompatActivity() {

    var contP = 0

    var inicioTiempo = 0
    var finalTiempo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_pulsar)



        btnPulsa.setOnClickListener { pulsaciones() }

    }


    fun pulsaciones() {

        if (contP == 0) {

            inicioTiempo = System.currentTimeMillis().toInt()

            contP += 1


        } else if (contP == 50) {

            finalTiempo = System.currentTimeMillis().toInt()

            var totalTiempo = finalTiempo - inicioTiempo

            toast("TIEMPO: " + totalTiempo)

            if (totalTiempo <= 50) {

                toast("HAS GANADO !!!")

            } else {


                toast("MALA SUERTE")

            }


        } else {

            contP += 1

        }

    }


}
