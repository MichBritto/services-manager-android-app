package br.com.tasksmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.tasksmanager.databinding.ActivityControlUserAccountsBinding


class ControlUserAccountsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityControlUserAccountsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlUserAccountsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
