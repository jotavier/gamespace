package com.gamespace.navigation

import android.content.Context
import android.content.Intent
import com.gamespace.home.presentation.ui.home.HomeActivity

internal class AppNavigatorImpl : AppNavigator {
    override fun home(context: Context?) {
        context?.run {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}