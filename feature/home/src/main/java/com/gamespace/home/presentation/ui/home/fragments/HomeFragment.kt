package com.gamespace.home.presentation.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gamespace.home.R
import com.gamespace.home.databinding.FragmentHomeBinding
import com.gamespace.home.presentation.dataui.UserDataUi
import com.gamespace.home.presentation.ui.home.adapters.GameAdapter
import com.gamespace.home.presentation.ui.home.viewmodels.UsersViewModel
import com.gamespace.home.presentation.ui.home.viewmodels.viewstates.UsersViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding by lazy { _binding!! }

    private val userAdapter by lazy { GameAdapter() }
    private val usersViewModel: UsersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        usersViewModel.fetchUsers()
        setupUsersAdapter()
        listenToUsersRequestState()
    }

    private fun setupUsersAdapter() {
        binding.users.adapter = userAdapter
    }

    private fun listenToUsersRequestState() {
        usersViewModel.usersViewState.observe(viewLifecycleOwner) { requestResult ->
            when (requestResult) {
                is UsersViewState.Error -> {
                    makeToast(getString(R.string.default_request_error_message))
                    showUsersView()
                }
                is UsersViewState.Loading -> showLoader()
                is UsersViewState.Success -> showLoadedUsers(requestResult.users)
            }
        }
    }

    private fun showLoader(): Unit = binding.run {
        progressBar.show()
        users.hide()
    }

    private fun showUsersView(): Unit = binding.run {
        progressBar.hide()
        users.show()
    }

    private fun showLoadedUsers(users: List<UserDataUi>) {
        userAdapter.addUsers(users)
        showUsersView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}