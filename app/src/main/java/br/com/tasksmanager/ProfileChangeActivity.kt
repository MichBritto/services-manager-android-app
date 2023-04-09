package br.com.tasksmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.tasksmanager.databinding.ActivityProfileChangeBinding

class ProfileChangeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileChangeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pagePasswordButton.setOnClickListener{
            val intent = Intent(this, PasswordChangeActivity::class.java)
            startActivity(intent)
        }
        binding.alterUserButton.setOnClickListener{
            Toast.makeText(this, "Altera Usuario Logica", Toast.LENGTH_LONG).show()
        }
    }
}