package br.com.tasksmanager

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.tasksmanager.databinding.ActivityAddOrderBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import model.Order
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID


class AddOrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //variaveis para configuração de nó de realtime database, gerar id e conversão de data em modelo brasileiro
        val database = FirebaseDatabase.getInstance()
        val ordersRef = database.getReference("ordens-servico")
        val orderId = UUID.randomUUID().toString()
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val currentDate = Date()
        val brazilianDate = formatter.format(currentDate)

        binding.btnRegistrar.setOnClickListener {
            //dados para serem guardados em nó do database
            val nomeOrdem = binding.txtNome.text.toString()
            val descricao = binding.txtDescricao.text.toString()
            //objeto
            val orderData = mapOf(
                "order" to nomeOrdem,
                "descricao" to descricao,
                "status" to "PENDENTE",
                "comentario" to listOf("Comment 1", "Comment 2"),
                "data" to brazilianDate
            )
            //guardando dado e gerando resposta na tela
            ordersRef.child(orderId!!).setValue(orderData, object : DatabaseReference.CompletionListener {
                override fun onComplete(databaseError: DatabaseError?, databaseReference: DatabaseReference) {
                    if (databaseError != null) {
                        Toast.makeText(applicationContext, "Erro ao registrar ordem de serviço", Toast.LENGTH_LONG).show()
                        Log.e("Error", "Error adding order: $databaseError")
                    } else {
                        binding.txtNome.setText("")
                        binding.txtDescricao.setText("")
                        Toast.makeText(applicationContext, "Ordem de serviço registrada com sucesso!", Toast.LENGTH_LONG).show()
                        Log.d("OK", "Order added successfully")
                    }
                }
            })
        }

    }
}