package br.com.tasksmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.tasksmanager.databinding.ActivityCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.txtIrPLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnCadastrar.setOnClickListener{
            val nome = binding.txtNome.text.toString()
            val email = binding.txtEmail.text.toString()
            val senha = binding.txtSenha.text.toString()
            val confirmarSenhar = binding.txtConfirmarSenha.text.toString()

            if(nome.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty() && confirmarSenhar.isNotEmpty()){
                if(senha == confirmarSenhar){
                    firebaseAuth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                            println("Erro: "+it.exception.toString())
                        }
                    }
                }
                else{
                    Toast.makeText(this, "As senhas não são iguais.", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Existem campos não preenchidos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}