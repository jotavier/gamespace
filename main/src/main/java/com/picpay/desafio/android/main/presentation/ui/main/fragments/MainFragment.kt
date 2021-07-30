package com.picpay.desafio.android.main.presentation.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.picpay.desafio.android.base.extensions.hide
import com.picpay.desafio.android.base.extensions.makeToast
import com.picpay.desafio.android.base.extensions.show
import com.picpay.desafio.android.base.fragment.BaseFragment
import com.picpay.desafio.android.main.R
import com.picpay.desafio.android.main.databinding.FragmentMainBinding
import com.picpay.desafio.android.main.presentation.dataui.UserDataUi
import com.picpay.desafio.android.main.presentation.ui.main.adapters.UserListAdapter
import com.picpay.desafio.android.main.presentation.ui.main.viewmodels.MainViewModel
import com.picpay.desafio.android.main.presentation.ui.main.viewmodels.viewstates.UsersRequestViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding by lazy { _binding!! }

    private val userListAdapter by lazy { UserListAdapter() }
    private val mainViewModel by viewModel<MainViewModel>()

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
        setupViewModelAsLifecyclerObserver()
        listenToUsersRequestViewState()
    }

    private fun listenToUsersRequestViewState() {
        mainViewModel.usersRequestViewState.observe(viewLifecycleOwner) { viewState ->
            when (viewState) {
                is UsersRequestViewState.Error -> binding.run {
                    makeToast(getString(R.string.default_request_error_message))
                    progressBar.hide()
                    users.show()
                }
                is UsersRequestViewState.Loading -> binding.run {
                    progressBar.show()
                    users.hide()
                }
                is UsersRequestViewState.Success -> showLoadedUsers(viewState.users)
            }
        }
    }

    private fun showLoadedUsers(users: List<UserDataUi>) {
        userListAdapter.addUsers(users)
        binding.users.adapter = userListAdapter
    }

    private fun setupViewModelAsLifecyclerObserver() {
        lifecycle.addObserver(mainViewModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}