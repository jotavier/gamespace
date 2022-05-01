package com.gamespace.home.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.gamespace.core.delegates.prepareModule
import com.gamespace.core.delegates.viewBinding
import com.gamespace.home.R
import com.gamespace.home.databinding.ActivityHomeBinding
import com.gamespace.home.di.HomeModule


class HomeActivity : AppCompatActivity(R.layout.home_activity_main) {

    private val modules by prepareModule<HomeModule>()
    private val binding: ActivityHomeBinding by viewBinding()
    private val navController by lazy { findNavController(binding.navHostContainer.id) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.toolbar.setupWithNavController(navController)
    }
}