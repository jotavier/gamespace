package com.gamespace.main.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gamespace.main.R
import com.gamespace.main.databinding.ActivityMainBinding

internal class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}