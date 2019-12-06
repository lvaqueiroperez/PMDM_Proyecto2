package com.ejemploapp2.pmdm_proyecto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto_internet.*
import org.jetbrains.anko.toast

class RetoInternet : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_internet)

        toast("RETO INTERNET")

        btnOk.setOnClickListener{comprobarRespuesta()}
    }


    fun comprobarRespuesta(){

        if(txtInputRespuesta2.text.toString() == "21,19618"){

            toast("HAS ACERTADO !")



        }else{

            toast("RESPUESTA INCORRECTA")

        }



    }
}
