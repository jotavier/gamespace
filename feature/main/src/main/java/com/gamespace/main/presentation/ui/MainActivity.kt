package com.gamespace.main.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gamespace.core.delegates.prepareModule
import com.gamespace.core.delegates.viewBinding
import com.gamespace.main.R
import com.gamespace.main.databinding.ActivityMainBinding
import com.gamespace.main.di.MainModule

internal class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val module by prepareModule<MainModule>()
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}