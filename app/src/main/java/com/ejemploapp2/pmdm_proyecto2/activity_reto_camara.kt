package com.ejemploapp2.pmdm_proyecto2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_reto_camara.*
import org.jetbrains.anko.toast

const val MY_PERMISSIONS_REQUEST_CAMERA = 1;
const val REQUEST_IMAGE_CAPTURE = 2;

class activity_reto_camara : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_camara)

        toast("RETO CÁMARA")

        btnCamara.setOnClickListener { sacarFoto() }


    }

    //HACE FALTA ESPECIFICAR EN EL MANIFEST !!!
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

    //PARA RECOGER LA FOTO: (se ha suprimido un error)
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //EN KOTLIN, CUANDO MANEJAMOS VARIABLES QUE PUEDEN SER NULL (data en este caso),
            //KOTLIN SIEMPRE NOS OBLIGARÁ A TRATAR ESOS VALORES QUE PUEDEN SER NULL DE ALGUNA MANERA
            //(por ej, con un "if" que controle si la variable es null o no (if...else...))
            //SI DE ALGUNA MANERA SABEMOS QUE ESA VARIABLE NO VA A SER NULL NUNCA, PODEMOS USAR EL OPERADOR "!!"

            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            imageCamara.setImageBitmap(imageBitmap)

            //COMPROBAMOS QUE SE HA SUPERADO EL RETO
            //HACER QUE COMPRUEBE LOS PIXELS DE LA IMAGEN SACADA, QUE CUMPLA CIERTA CONDICION
            if (imageCamara != null) {

                toast("RETO SUPERADO")

                val resultado1 = 1

                val data = Intent()

                data.putExtra("resultado", resultado1)
                setResult(Activity.RESULT_OK, data)


            } else {
                toast("RETO NO SUPERADO")

                val resultado2 = 0

                val data = Intent()

                data.putExtra("resultado", resultado2)
                setResult(Activity.RESULT_OK, data)
            }


        }
    }


}
