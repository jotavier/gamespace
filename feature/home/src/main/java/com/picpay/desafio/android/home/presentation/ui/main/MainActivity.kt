package com.picpay.desafio.android.home.presentation.ui.main

import android.os.Bundle
import com.picpay.desafio.android.base.activity.BaseActivity
import com.picpay.desafio.android.home.databinding.ActivityMainBinding
import com.picpay.desafio.android.home.di.MainModule

class MainActivity : BaseActivity(MainModule) {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}