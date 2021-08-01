package com.picpay.desafio.android.home.presentation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.picpay.desafio.android.base.activity.BaseActivity
import com.picpay.desafio.android.home.databinding.ActivityMainBinding

class HomeActivity : BaseActivity() {

    companion object {
        fun newInstance(context: Context) =
            Intent(context, HomeActivity::class.java)
    }

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}