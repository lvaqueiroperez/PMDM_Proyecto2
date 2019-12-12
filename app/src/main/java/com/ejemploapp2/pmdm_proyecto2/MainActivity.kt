package com.ejemploapp2.pmdm_proyecto2

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

//INFO:
/*
App en la que el user tendrá que superar 4 retos, cada vez que se abandone o complete un reto,
el botón de acceso al mismo se bloqueará y cambiará de color, añadiando o no puntos a la puntuación
del jugador
 */


//VARIABLES GLOBALES "requestCode":
const val INTERNET_REQUEST = 1
const val CAMARA_REQUEST = 2
const val MATES_REQUEST = 3
const val PULSAR_REQUEST = 4

var puntos = 0


class MainActivity : AppCompatActivity() {

    //En "onCreate" son creados los listener de cada botón y un mensaje de bienvenida
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPrueba1.setOnClickListener { accesoRetoInternet() }

        btnPrueba2.setOnClickListener { accesoRetoCamara() }

        btnPrueba3.setOnClickListener { accesoRetoMates() }

        btnPrueba4.setOnClickListener { accesoRetoPulsar() }



        toast("BIENVENIDO :D")


    }

    //Función donde se configura el acceso al reto 1 mediante su botón correspondiente
    fun accesoRetoInternet() {

        val miIntent = Intent(this, RetoInternet::class.java)

        startActivityForResult(miIntent, INTERNET_REQUEST)

    }

    //Función donde se configura el acceso al reto 2 mediante su botón correspondiente
    fun accesoRetoCamara() {

        val miIntent = Intent(this, activity_reto_camara::class.java)

        startActivityForResult(miIntent, CAMARA_REQUEST)

    }

    //Función donde se configura el acceso al reto 3 mediante su botón correspondiente
    fun accesoRetoMates() {

        val miIntent = Intent(this, RetoMates::class.java)

        startActivityForResult(miIntent, MATES_REQUEST)


    }

    //Función donde se configura el acceso al reto 4 mediante su botón correspondiente
    fun accesoRetoPulsar() {

        val miIntent = Intent(this, RetoPulsar::class.java)

        startActivityForResult(miIntent, PULSAR_REQUEST)


    }

    //Función donde accederemos a los datos "ActivityResult" de cada Activity mediante su "requestCode"
    //En cada sección, si el "reto" se ha completado, se cambiará a color verde el botón correspondiente a
    //ese reto y se bloqueará para que no se pueda acceder a él
    //Además, la puntuación del usuario se actualizará
    //NOTA: se ha usado una variable int para indicar si se ha superado (1) o fallado (0) la prueba
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

                        puntos += 25
                        txtPuntuacion.setText("Puntuación: " + puntos)

                    } else {

                        btnPrueba1.setEnabled(false)
                        btnPrueba1.setTextColor(Color.RED)


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

                        puntos += 25
                        txtPuntuacion.setText("Puntuación: " + puntos)

                    } else {

                        btnPrueba2.setEnabled(false)
                        btnPrueba2.setTextColor(Color.RED)

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

                        puntos += 25
                        txtPuntuacion.setText("Puntuación: " + puntos)


                    } else {

                        btnPrueba3.setEnabled(false)
                        btnPrueba3.setTextColor(Color.RED)
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

                        puntos += 25
                        txtPuntuacion.setText("Puntuación: " + puntos)


                    } else {

                        btnPrueba4.setEnabled(false)
                        btnPrueba4.setTextColor(Color.RED)
                    }


                }

            }


        }


    }


}
