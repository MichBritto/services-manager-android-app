package br.com.tasksmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.tasksmanager.databinding.ActivityAddComentBinding

class AddComentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddComentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddComentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}