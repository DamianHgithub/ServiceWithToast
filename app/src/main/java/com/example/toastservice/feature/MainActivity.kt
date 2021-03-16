package com.example.toastservice.feature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.toastservice.R
import com.example.toastservice.databinding.ActivityMainBinding
import com.example.toastservice.util.ToastService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMessage.setOnClickListener {
            val serviceIntent = Intent(this, ToastService::class.java)
            startService(serviceIntent)
        }
    }
}