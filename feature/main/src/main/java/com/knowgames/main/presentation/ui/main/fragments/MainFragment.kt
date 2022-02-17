package com.knowgames.main.presentation.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.picpay.desafio.knowgames.base.extensions.finish
import com.picpay.desafio.knowgames.base.fragment.BaseFragment
import com.picpay.desafio.knowgames.core.abstractions.navigator.Navigator
import com.picpay.desafio.knowgames.main.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : BaseFragment() {

    @Inject
    lateinit var navigator: Navigator

    private var _binding: FragmentMainBinding? = null
    private val binding by lazy { _binding!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.navigateToHome(requireContext())
        finish()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }
}