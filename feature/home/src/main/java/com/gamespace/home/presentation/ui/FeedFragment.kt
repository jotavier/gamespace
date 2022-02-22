package com.gamespace.home.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gamespace.core.delegates.viewBinding
import com.gamespace.home.R
import com.gamespace.home.databinding.FragmentHomeBinding
import com.gamespace.home.presentation.ui.feed.adapter.game.GameAdapter
import com.gamespace.home.presentation.ui.feed.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()

    private val userAdapter by lazy { GameAdapter() }
    private val usersViewModel: UsersViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        usersViewModel.fetchUsers()
    }
}
