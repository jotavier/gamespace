package com.gamespace.home.presentation.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gamespace.core.delegates.viewBinding
import com.gamespace.home.R
import com.gamespace.home.databinding.ActivityHomeBinding
import com.gamespace.home.domain.entities.User
import com.picpay.desafio.gamespace.home.R
import com.picpay.desafio.gamespace.home.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(R.layout.activity_home) {

    private val binding: ActivityHomeBinding by viewBinding()
    private val navController by lazy { findNavController(binding.navHostContainer.id) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val user: List<User> = listOf()
        binding.toolbar.setupWithNavController(navController)
    }
}