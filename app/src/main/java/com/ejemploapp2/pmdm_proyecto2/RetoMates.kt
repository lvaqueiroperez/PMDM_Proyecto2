package com.ejemploapp2.pmdm_proyecto2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto_mates.*
import org.jetbrains.anko.toast

class RetoMates : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_mates)

        btnComprobarMates.setOnClickListener { comprobar() }

    }


    fun comprobar() {

        if ((chk1.isChecked == true) && (chk4.isChecked == false) && (chk2.isChecked == false) && (chk3.isChecked == false)) {

            toast("CORRECTO !")

            val resultado1 = 1

            val data = Intent()

            data.putExtra("resultado", resultado1)
            setResult(Activity.RESULT_OK, data)


        } else {

            toast("RESPUESTA INCORRECTA")

            val resultado2 = 0

            val data = Intent()

            data.putExtra("resultado", resultado2)


        }


    }


}
