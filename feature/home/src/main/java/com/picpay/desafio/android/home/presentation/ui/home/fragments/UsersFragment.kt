package com.picpay.desafio.android.home.presentation.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.picpay.desafio.android.base.extensions.hide
import com.picpay.desafio.android.base.extensions.makeToast
import com.picpay.desafio.android.base.extensions.show
import com.picpay.desafio.android.base.fragment.BaseFragment
import com.picpay.desafio.android.core.di.factories.ViewModelFactory
import com.picpay.desafio.android.home.R
import com.picpay.desafio.android.home.databinding.FragmentUsersBinding
import com.picpay.desafio.android.home.presentation.dataui.UserDataUi
import com.picpay.desafio.android.home.presentation.ui.home.adapters.UserListAdapter
import com.picpay.desafio.android.home.presentation.ui.home.viewmodels.UsersViewModel
import com.picpay.desafio.android.home.presentation.ui.home.viewmodels.viewstates.UsersViewState
import javax.inject.Inject

class UsersFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentUsersBinding? = null
    private val binding: FragmentUsersBinding by lazy { _binding!! }

    private val userAdapter by lazy { UserListAdapter() }
    private val usersViewModel by viewModels<UsersViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        usersViewModel.getUsers()
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