package com.picpay.desafio.android.navigation

import android.content.Context
import com.picpay.desafio.android.core.abstractions.navigator.Navigator
import com.picpay.desafio.android.home.presentation.ui.home.HomeActivity
import javax.inject.Inject

internal class NavigatorImpl
@Inject constructor() : Navigator {
    override fun navigateToHome(context: Context?) {
        context?.run { startActivity(HomeActivity.newInstance(this)) }
    }
}