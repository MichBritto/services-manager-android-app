package br.com.tasksmanager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.tasksmanager.databinding.ActivityPasswordChangeBinding

class PasswordChangeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPasswordChangeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changePasswordButton.setOnClickListener{
            Toast.makeText(this, "Altera Senha Logica", Toast.LENGTH_LONG).show()
        }
    }
}