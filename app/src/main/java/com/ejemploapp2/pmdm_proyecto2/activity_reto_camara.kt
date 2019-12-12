package com.ejemploapp2.pmdm_proyecto2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import kotlinx.android.synthetic.main.activity_reto_camara.*
import kotlinx.android.synthetic.main.activity_reto_internet.*
import kotlinx.android.synthetic.main.activity_reto_mates.*
import org.jetbrains.anko.toast
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View

//requestCodes relativos a la configuración del acceso a la cámara del dispositivo y sus permisos
const val MY_PERMISSIONS_REQUEST_CAMERA = 1;
const val REQUEST_IMAGE_CAPTURE = 2;

//Activity del reto "Cámara"
class activity_reto_camara : AppCompatActivity() {
    //Configuramos los listener de cada botón y ocultamos el botón de "volver"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_camara)

        btnVolver2.setVisibility(View.INVISIBLE)


        toast("RETO CÁMARA")

        btnCamara.setOnClickListener { sacarFoto() }
        btnVolver2.setOnClickListener { volver() }


    }

    //Función que controla el acceso a la cámara, comprobando si existen permisos y preguntando por ellos
    //en caso negativo
    fun sacarFoto() {

        //COMPROBAMOS PERMISOS
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            toast("HACE FALTA DAR PERMISO")


            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA), MY_PERMISSIONS_REQUEST_CAMERA
            )


        } else {

            toast("PERMISO ACTIVO")

            //EJECUTAMOS LA ACTIVITY DE LA CÁMARA UNA VEZ TENGAMOS EL PERMISO
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }


        }


    }


    //Función encargada de recoger la foto y, convirtiéndola en un "bitMap" y accediendo a sus píxeles,
    //de comprobar que la foto contiene el color rojo en su parte céntrica

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //EN KOTLIN, CUANDO MANEJAMOS VARIABLES QUE PUEDEN SER NULL (data en este caso),
            //KOTLIN SIEMPRE NOS OBLIGARÁ A TRATAR ESOS VALORES QUE PUEDEN SER NULL DE ALGUNA MANERA
            //(por ej, con un "if" que controle si la variable es null o no (if...else...))
            //SI DE ALGUNA MANERA SABEMOS QUE ESA VARIABLE NO VA A SER NULL NUNCA, PODEMOS USAR EL OPERADOR "!!"

            //obtenemos el bitmap de la imagen
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            imageCamara.setImageBitmap(imageBitmap)
            //accedemos a los píxeles de la imagen
            val pixel = imageBitmap.getPixel(imageBitmap.width / 2, imageBitmap.height / 2)

            //obtenemos los canales de color y comparamos los colores de ciertos píxeles
            val redValue = pixel shr 16 and 0xff

            val blueValue = pixel and 0xff

            val greenValue = pixel shr 8 and 0xff

            if (redValue > 100 && blueValue < 60 && greenValue < 60) {

                toast("RETO SUPERADO")
                btnVolver2.setVisibility(View.VISIBLE)
                btnCamara.setEnabled(false)
                val resultado1 = 1

                val data = Intent()

                data.putExtra("resultado", resultado1)
                setResult(Activity.RESULT_OK, data)


            } else {
                toast("RETO NO SUPERADO")
                btnVolver2.setVisibility(View.VISIBLE)
                btnCamara.setEnabled(false)
                val resultado2 = 0

                val data = Intent()

                data.putExtra("resultado", resultado2)
                setResult(Activity.RESULT_OK, data)
            }


        }
    }

    //función para la congiguración del botón volver
    fun volver() {

        finish()

    }


}
