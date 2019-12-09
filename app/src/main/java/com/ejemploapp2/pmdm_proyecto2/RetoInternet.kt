package com.ejemploapp2.pmdm_proyecto2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto_internet.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.toast

class RetoInternet : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_internet)

        toast("RETO INTERNET")

        btnOk.setOnClickListener { comprobarRespuesta() }

        //PARA LAS BÚSQUEDAS EN INTERNET:
        btnBuscar.setOnClickListener { browse("https://es.wikipedia.org/wiki/Gran_Muralla_China") }
    }


    fun comprobarRespuesta() {

        if (txtInputRespuesta2.text.toString() == "21200") {

            toast("HAS ACERTADO !")

            //Si la prueba se ha superado, "data" tendrá el valor de 1
            val resultado1 = 1

            val data = Intent()

            data.putExtra("resultado", resultado1)
            setResult(Activity.RESULT_OK, data)


        } else {

            toast("RESPUESTA INCORRECTA")

            //Si la prueba NO se ha superado, "data" tendrá el valor de 0

            val resultado2 = 0

            val data = Intent()

            data.putExtra("resultado", resultado2)
            setResult(Activity.RESULT_OK, data)

        }


    }


}
