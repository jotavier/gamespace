package com.picpay.desafio.android.main.presentation.ui.main.adapters

import android.view.ViewGroup
import com.picpay.desafio.android.base.adapter.BaseListAdapter
import com.picpay.desafio.android.base.extensions.inflate
import com.picpay.desafio.android.main.R
import com.picpay.desafio.android.main.databinding.AdapterUserListItemBinding
import com.picpay.desafio.android.main.presentation.dataui.UserDataUi
import com.picpay.desafio.android.main.presentation.ui.main.adapters.diffutils.UserListItemDiffCallback
import com.picpay.desafio.android.main.presentation.ui.main.adapters.listitems.UserListItem
import com.picpay.desafio.android.main.presentation.ui.main.adapters.viewholders.UserListItemViewHolder

class UserListAdapter : BaseListAdapter<UserListItem, UserListItemViewHolder>
    (UserListItemDiffCallback()) {

    override fun getItemViewType(position: Int): Int = R.layout.adapter_user_list_item

    override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): UserListItemViewHolder {
        val view = parent.inflate(layoutId)
        return UserListItemViewHolder(AdapterUserListItemBinding.bind(view))
    }

    fun addUsers(users: List<UserDataUi>) {
        submitList(users.map { user -> UserListItem(user) })
    }
}