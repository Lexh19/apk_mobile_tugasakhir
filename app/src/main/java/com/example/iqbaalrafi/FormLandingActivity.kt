package com.example.iqbaalrafi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.iqbaalrafi.databinding.ActivityFormLandingBinding

class FormLandingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}