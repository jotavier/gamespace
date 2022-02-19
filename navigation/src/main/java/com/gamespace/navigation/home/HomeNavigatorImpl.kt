package com.gamespace.navigation.home

import android.content.Context
import android.content.Intent
import com.gamespace.home.presentation.ui.home.HomeActivity

internal class HomeNavigatorImpl : HomeNavigator {
    override fun start(context: Context?) {
        context?.run {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}