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

class RetoPulsar : AppCompatActivity() {

    var contP = 0

    var inicioTiempo = 0
    var finalTiempo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_pulsar)

        btnVolver1.setVisibility(View.INVISIBLE)

        btnPulsa.setOnClickListener { pulsaciones() }

        btnVolver1.setOnClickListener { volver() }

    }


    fun pulsaciones() {

        if (contP == 0) {

            inicioTiempo = System.currentTimeMillis().toInt()

            contP += 1


        } else if (contP == 50) {

            finalTiempo = System.currentTimeMillis().toInt()

            var totalTiempo = finalTiempo - inicioTiempo



            if (totalTiempo <= 10000) {

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

    fun volver() {

        finish()

    }


}
