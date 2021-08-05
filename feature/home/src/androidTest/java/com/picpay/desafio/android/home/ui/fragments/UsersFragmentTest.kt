package com.picpay.desafio.android.home.ui.fragments

import androidx.core.view.isVisible
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.picpay.desafio.android.home.R
import com.picpay.desafio.android.home.presentation.ui.home.fragments.UsersFragment
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UsersFragmentTest : TestCase() {

    private lateinit var scenario: FragmentScenario<UsersFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer(themeResId = R.style.AppTheme)
        scenario.moveToState(Lifecycle.State.CREATED)
    }

    @Test
    fun should_ShowUsersInList() {
        onView(withId(R.id.users)).check { view, _ ->
            view.isVisible
        }
    }
}