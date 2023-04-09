package br.com.tasksmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import br.com.tasksmanager.databinding.ActivityLoginBinding
import br.com.tasksmanager.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSair.setOnClickListener{
            firebaseAuth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}