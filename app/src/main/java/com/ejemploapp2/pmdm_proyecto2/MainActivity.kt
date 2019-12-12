package com.ejemploapp2.pmdm_proyecto2

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

//CADA ESTRELLA ES UN BOTÓN CON EL QUE SE ACCEDE A UNA ACTIVIDAD NUEVA
//NECESITAMOS SABER MEDIANTE UNA VARIANBLE SI LA ACTIVIDAD QUE HEMOS VISITADO SE HA COMPLETADO CORRECTAMENTE
//O NO, SI ES EL CASO PUES EL BOTÓN CAMBIARÁ DE COLOR

//VARIABLES GLOBALES:
const val INTERNET_REQUEST = 1
const val CAMARA_REQUEST = 2
const val MATES_REQUEST = 3
const val PULSAR_REQUEST = 4

var contBien = 0
var contMal = 0
var contTotal = 0


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPrueba1.setOnClickListener { accesoRetoInternet() }

        btnPrueba2.setOnClickListener { accesoRetoCamara() }

        btnPrueba3.setOnClickListener { accesoRetoMates() }

        btnPrueba4.setOnClickListener { accesoRetoPulsar() }

        txtPuntuacion.setVisibility(View.INVISIBLE)

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

    fun accesoRetoMates() {

        val miIntent = Intent(this, RetoMates::class.java)

        startActivityForResult(miIntent, MATES_REQUEST)


    }

    fun accesoRetoPulsar() {

        val miIntent = Intent(this, RetoPulsar::class.java)

        startActivityForResult(miIntent, PULSAR_REQUEST)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        //RETO INTERNET
        if (requestCode == INTERNET_REQUEST) {

            btnPrueba1.setEnabled(false)

            if (resultCode == Activity.RESULT_OK) {

                if (data != null) {

                    val resultado = data.getIntExtra("resultado", 0)

                    if (resultado == 1) {

                        btnPrueba1.setEnabled(false)

                        //CAMBIAMOS LA APARIENCIA DEL BOTÓN (probamos primero con la label)
                        btnPrueba1.setTextColor(Color.GREEN)
                        contBien += 1

                        if (contTotal == 4) {

                            resultadoFinal(contBien)

                        }

                    } else {

                        btnPrueba1.setEnabled(false)
                        contMal += 1

                        contTotal += 1


                        if (contTotal == 4) {

                            resultadoFinal(contBien)

                        }

                    }



                }

            }

            //RETO CÁMARA
        } else if (requestCode == CAMARA_REQUEST) {


            if (resultCode == Activity.RESULT_OK) {

                if (data != null) {

                    val resultado = data.getIntExtra("resultado", 0)

                    if (resultado == 1) {

                        btnPrueba2.setEnabled(false)

                        //CAMBIAMOS LA APARIENCIA DEL BOTÓN (probamos primero con la label)
                        btnPrueba2.setTextColor(Color.GREEN)
                        contBien += 1

                    } else {

                        btnPrueba2.setEnabled(false)
                        contMal += 1

                        contTotal += 1
                    }

                    if (contTotal == 4) {

                        resultadoFinal(contBien)

                    }


                }

            }


        }
        //RETO MATES
        else if (requestCode == MATES_REQUEST) {


            if (resultCode == Activity.RESULT_OK) {

                if (data != null) {

                    val resultado = data.getIntExtra("resultado", 0)


                    if (resultado == 1) {
                        btnPrueba3.setTextColor(Color.GREEN)
                        btnPrueba3.setEnabled(false)
                        contBien += 1

                    } else {

                        btnPrueba3.setEnabled(false)
                        contMal += 1

                        contTotal += 1
                    }

                    if (contTotal == 4) {

                        resultadoFinal(contBien)

                    }

                }

            }

         //RETO PULSAR
        } else if (requestCode == PULSAR_REQUEST) {


            if (resultCode == Activity.RESULT_OK) {

                if (data != null) {

                    val resultado = data.getIntExtra("resultado", 0)


                    if (resultado == 1) {
                        btnPrueba4.setTextColor(Color.GREEN)


                        btnPrueba4.setEnabled(false)
                        contBien += 1
                        contTotal += 1

                    } else {

                        btnPrueba4.setEnabled(false)
                        contMal += 1
                        contTotal += 1
                    }

                    if (contTotal == 4) {

                        resultadoFinal(contBien)

                    }

                }

            }


        }


    }


    fun resultadoFinal(puntTotal: Int) {



        when (puntTotal) {

            4 -> txtPuntuacion.setText("Puntuación: 100")

            3 -> txtPuntuacion.setText("Puntuación: 75")

            2 -> txtPuntuacion.setText("Puntuación: 50")

            1 -> txtPuntuacion.setText("Puntuación: 25 :(")

        }

        txtPuntuacion.setVisibility(View.VISIBLE)
    }

}
