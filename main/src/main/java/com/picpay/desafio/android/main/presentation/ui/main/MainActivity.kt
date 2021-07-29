package com.picpay.desafio.android.main.presentation.ui.main

import android.os.Bundle
import com.picpay.desafio.android.base.activity.BaseActivity
import com.picpay.desafio.android.main.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}