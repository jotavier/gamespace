package com.gamespace.home.presentation.ui.feed

import androidx.fragment.app.Fragment
import com.gamespace.core.delegates.viewBinding
import com.gamespace.home.R
import com.gamespace.home.databinding.FragmentHomeBinding
import com.gamespace.home.presentation.ui.feed.adapter.game.GameAdapter

class FeedFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()

    private val gameAdapter by lazy { GameAdapter() }

}
