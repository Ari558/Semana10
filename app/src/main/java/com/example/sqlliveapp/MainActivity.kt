package com.example.sqlliveapp

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etn_Codigo: EditText
    private lateinit var etn_Descripcion: EditText
    private lateinit var etn_precio: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etn_Codigo =findViewById(R.id.etn_Codigo)
        etn_Descripcion= findViewById(R.id.etn_Descripcion)
        etn_precio = findViewById(R.id.etn_precio)
    }

    //Funcion para registrar producto
    fun Registrar(v: View){
        //se crea la coneccion
        val admin = adminSQLite(this, "Tienda", null, 1)
        val basededatos:SQLiteDatabase = admin.writableDatabase

        val codigo = etn_Codigo.text.toString()
        val descripcion = etn_Descripcion.text.toString()
        val precio = etn_precio.text.toString()

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            val registro =ContentValues()
            registro.put("codigo",codigo)
            registro.put("Descripcion", descripcion)
            registro.put ("precio",precio)

            basededatos.insert("articulo", null, registro)
            basededatos.close()
            etn_Codigo.setText("")
            etn_Descripcion.setText("")
            etn_precio.setText("")

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Debe llenar todo los campos para registrar", Toast.LENGTH_SHORT).show()



        }

    }

}