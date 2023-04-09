package br.com.tasksmanager

import adapter.OrderAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.tasksmanager.AddOrderActivity
import br.com.tasksmanager.databinding.ActivityMenuBinding
import model.Order

class MenuActivity : AppCompatActivity(), OrderAdapter.OnOrderClickListener {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var adapter: OrderAdapter
    private var selected_item: Order? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val orders = listOf(
            Order(1, "Order 1", "Description", "Accepted"),
            Order(2, "Order 2", "Description","Accepted"),
            Order(3, "Order 3", "Description","Accepted")
        )

        adapter = OrderAdapter(this, orders, this)
        binding.ordemServico.layoutManager = LinearLayoutManager(this)
        binding.ordemServico.adapter = adapter

        binding.addOrderButton.setOnClickListener {
            Toast.makeText(this, "Clicou no botão", Toast.LENGTH_LONG).show()
            val intent = Intent(this, AddOrderActivity::class.java)
            startActivity(intent)
        }

        binding.editarPerfilButton.setOnClickListener{
            val intent = Intent(this, ProfileChangeActivity::class.java)
            startActivity(intent)
        }

        binding.btnDetailOrder.setOnClickListener {
            if (selected_item != null) {
                val intent = Intent(this, OrderDetailActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onOrderClick(order: Order) {
        selected_item = order
    }
}
