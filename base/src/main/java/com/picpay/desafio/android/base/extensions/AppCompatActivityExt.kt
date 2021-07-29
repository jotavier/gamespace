package com.picpay.desafio.android.base.extensions

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

fun AppCompatActivity.findNavController(@IdRes navHostContainerId: Int) =
    (supportFragmentManager.findFragmentById(navHostContainerId) as NavHostFragment).navController