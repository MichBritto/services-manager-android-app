package br.com.tasksmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.tasksmanager.databinding.ActivityOrderManagementBinding

class OrderManagementActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderManagementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}