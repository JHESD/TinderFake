package com.example.faketinder.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.faketinder.FavoriteUsersActivity
import com.example.faketinder.R
import com.example.faketinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupEventListener()
    }

    private fun setupEventListener() {
        binding.bttFavoriteUser.setOnClickListener(
            doFavorite()
        )
    }

    private fun doFavorite(): View.OnClickListener? {
        val intents = Intent(
            this,
            FavoriteUsersActivity::class.java)
        startActivity(intents)
        return null
    }
}