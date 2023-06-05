package com.example.dm2y2023projeto7

import android.app.Activity
import android.content.Intent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class novoCarro : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_carro)

        val btnSalvarCarro = findViewById<Button>(R.id.btnSalvarCarro)

        btnSalvarCarro.setOnClickListener{
            val nomeCarro = findViewById<EditText>(R.id.edtNomeCarro).text.toString()
            val valorCarro = findViewById<EditText>(R.id.edtValorCarro).text.toString()

            val dados = hashMapOf(
                "nomecarro" to nomeCarro,
                "valorcarro" to valorCarro
            )

            db.collection("carro").add(dados)
                .addOnSuccessListener {
                    val intent = Intent()
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
                .addOnFailureListener{
                    Toast.makeText(this, "Falha ao salvar carro", Toast.LENGTH_SHORT).show()
                }
        }
    }
}