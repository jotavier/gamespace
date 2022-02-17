package com.knowgames.main.presentation.ui.main

import android.os.Bundle
import com.picpay.desafio.knowgames.base.activity.BaseActivity
import com.picpay.desafio.knowgames.main.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}