/*
package com.example.dm2y2023projeto7

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class listaCarrocopia : AppCompatActivity() {

    val db = Firebase.firestore

    val listaDados = mutableListOf<novoCarro>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_carro)

        BuscarCarrosFirebase()

        val btnNovoCarro = findViewById<Button>(R.id.btnNovoCarro)

        btnNovoCarro.setOnClickListener{
            val intent = Intent(this, novoCarro::class.java)
            addProductRequest.launch(intent)
        }

        val listaCarros = findViewById<ListView>(R.id.lstCarro)

        listaCarros.setOnItemLongClickListener { parent, view, position, id ->
            val builder = AlertDialog.Builder(this)
            builder
                .setTitle("APAGAR REGISTRO")

                .setMessage("Deseja deletar o carro?")

                .setPositiveButton("Sim") { dialog, which ->
                    val carro = listaDados[position]

                    ExcluirCarro(carro.id)

                }.setNegativeButton("Não"){ dialog, which ->
                    Toast.makeText(this, "Carro não deletado", Toast.LENGTH_LONG).show()
                }
                .show()
            true
        }
    }

    private val addProductRequest = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            BuscarCarrosFirebase()
        }
    }

    private fun BuscarCarrosFirebase(){
        db.collection("carro")
            .get()
            .addOnSuccessListener { querySnapshot ->
                ListarCarros(querySnapshot)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Falha ao excluir veículo", Toast.LENGTH_SHORT).show()
            }
    }

    data class Carro(
        val id: String,
        val nomeCarro: String,
        val valorCarro: String,
    )


    private fun ListarCarros(querySnapshot: QuerySnapshot) {
        listaDados.clear()

        for (document in querySnapshot) {
            val id = document.id
            val nomeCarro = document.getString("nomecarro")
            val valorCarro = document.getString("valorcarro")

            if (id != null && nomeCarro != null && valorCarro != null) {
                val carro = Carro(id, nomeCarro, valorCarro)
                listaDados.add(carro)
            }
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDados.map {
            "Nome: ${it.nomeCarro}\nValor: R$ ${it.valorCarro}"
        })

        val lista = findViewById<ListView>(R.id.lstCarro)
        lista.adapter = adapter
    }

    private fun ExcluirCarro(id: String) {
        val documento = db.collection("carro").document(id)

        documento.delete()
            .addOnSuccessListener {
                Toast.makeText(this, "Carro excluído", Toast.LENGTH_SHORT).show()
                BuscarCarrosFirebase()
            }
            .addOnFailureListener{
                Toast.makeText(this, "Falha ao excluir carro", Toast.LENGTH_SHORT).show()
            }
    }
}*/
