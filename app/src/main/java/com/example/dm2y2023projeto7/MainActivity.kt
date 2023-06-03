package com.example.dm2y2023projeto7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSalvar).setOnClickListener {
            val nome = findViewById<EditText>(R.id.edtNome).text.toString()
            val curso = findViewById<EditText>(R.id.edtCurso).text.toString()

            val dados = hashMapOf(
                "nome" to nome,
                "curso" to curso
            )

            db.collection("pessoa").add(dados)
                .addOnSuccessListener {
                    Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Erro!", Toast.LENGTH_SHORT).show()
                }
        }

    }
}