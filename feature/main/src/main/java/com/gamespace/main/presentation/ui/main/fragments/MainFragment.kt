package com.gamespace.main.presentation.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gamespace.main.R
import com.gamespace.main.databinding.FragmentMainBinding
import com.gamespace.main.presentation.extensions.onAnimationEnd
import com.gamespace.navigation.AppNavigator
import org.koin.android.ext.android.inject

class MainFragment : Fragment(R.layout.fragment_main) {

    private val appNav: AppNavigator by inject()
    private var _binding: FragmentMainBinding? = null
    private val binding by lazy { _binding!! }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOnAnimationEnd()
    }

    private fun setupOnAnimationEnd() {
        binding.animationView.onAnimationEnd { appNav.home(context) }
    }
}