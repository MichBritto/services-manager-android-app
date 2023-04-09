package br.com.tasksmanager

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.tasksmanager.databinding.ActivityAddOrderBinding


class AddOrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myButton = findViewById<Button>(R.id.button)

        myButton.setOnClickListener {
            // Handle the click event here
            Toast.makeText(this, "cliquei no botao", Toast.LENGTH_LONG).show()
        }

    }


}