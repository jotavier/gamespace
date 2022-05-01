package com.gamespace.main.presentation.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gamespace.core.delegates.prepareModule
import com.gamespace.core.delegates.viewBinding
import com.gamespace.main.R
import com.gamespace.main.databinding.MainActivitySplashBinding
import com.gamespace.main.di.splash.SplashModule
import com.gamespace.main.presentation.splash.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SplashActivity : AppCompatActivity() {

    private val module by prepareModule(SplashModule)
    private val binding: MainActivitySplashBinding by viewBinding()

    private val viewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}