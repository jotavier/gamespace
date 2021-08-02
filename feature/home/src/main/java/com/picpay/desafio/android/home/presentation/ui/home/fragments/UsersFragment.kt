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
import com.picpay.desafio.android.home.presentation.ui.home.viewmodels.states.UsersRequestState
import javax.inject.Inject

class UsersFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentUsersBinding? = null
    private val binding: FragmentUsersBinding by lazy { _binding!! }

    private val userListAdapter by lazy { UserListAdapter() }
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
        listenToUsersRequestState()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.also {

        }
    }

    private fun listenToUsersRequestState() {
        usersViewModel.usersRequestState.observe(viewLifecycleOwner) { requestResult ->
            when (requestResult) {
                is UsersRequestState.Error -> {
                    makeToast(getString(R.string.default_request_error_message))
                    showUsersView()
                }
                is UsersRequestState.Loading -> showLoader()
                is UsersRequestState.Success -> showLoadedUsers(requestResult.users)
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
        userListAdapter.addUsers(users)
        binding.users.adapter = userListAdapter
        showUsersView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}