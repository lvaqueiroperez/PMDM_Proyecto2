package com.ejemploapp2.pmdm_proyecto2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_reto_mates.*
import org.jetbrains.anko.toast

//Activity del reto Mates
class RetoMates : AppCompatActivity() {
    //Configuramos los listener de cada botón y ocultamos el botón de volver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_mates)

        btnVolver3.setVisibility(View.INVISIBLE)
        btnVolver3.setOnClickListener { volver() }
        btnComprobarMates.setOnClickListener { comprobar() }


    }

    //Función para comprobar que la opción marcada en los checkBox es la correcta
    fun comprobar() {

        if ((chk1.isChecked == true) && (chk4.isChecked == false) && (chk2.isChecked == false) && (chk3.isChecked == false)) {

            toast("CORRECTO !")
            btnVolver3.setVisibility(View.VISIBLE)
            btnComprobarMates.setEnabled(false)

            val resultado1 = 1

            val data = Intent()

            data.putExtra("resultado", resultado1)
            setResult(Activity.RESULT_OK, data)


        } else {

            toast("RESPUESTA INCORRECTA")
            btnComprobarMates.setEnabled(false)
            btnVolver3.setVisibility(View.VISIBLE)

            val resultado2 = 0

            val data = Intent()

            data.putExtra("resultado", resultado2)

            setResult(Activity.RESULT_OK, data)


        }


    }

    //Función para la configuración del botón volver
    fun volver() {

        finish()

    }


}
