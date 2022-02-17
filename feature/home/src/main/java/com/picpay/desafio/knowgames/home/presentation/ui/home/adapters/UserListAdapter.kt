package com.picpay.desafio.knowgames.home.presentation.ui.home.adapters

import android.view.ViewGroup
import com.picpay.desafio.knowgames.base.adapter.BaseListAdapter
import com.picpay.desafio.knowgames.base.extensions.inflate
import com.picpay.desafio.knowgames.home.R
import com.picpay.desafio.knowgames.home.databinding.AdapterUserListItemBinding
import com.picpay.desafio.knowgames.home.presentation.dataui.UserDataUi
import com.picpay.desafio.knowgames.home.presentation.ui.home.adapters.diffutils.UserListItemDiffCallback
import com.picpay.desafio.knowgames.home.presentation.ui.home.adapters.listitems.UserListItem
import com.picpay.desafio.knowgames.home.presentation.ui.home.adapters.viewholders.UserListItemViewHolder

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