package com.gamespace.home.presentation.ui.home.adapters

import android.view.ViewGroup
import com.picpay.desafio.gamespace.base.adapter.BaseListAdapter
import com.picpay.desafio.gamespace.base.extensions.inflate
import com.picpay.desafio.gamespace.home.R
import com.picpay.desafio.gamespace.home.databinding.AdapterUserListItemBinding
import com.gamespace.home.presentation.dataui.UserDataUi
import com.gamespace.home.presentation.ui.home.adapters.diffutils.UserListItemDiffCallback
import com.gamespace.home.presentation.ui.home.adapters.listitems.UserListItem
import com.gamespace.home.presentation.ui.home.adapters.viewholders.UserListItemViewHolder

class GameAdapter : BaseListAdapter<UserListItem, UserListItemViewHolder>
    (UserListItemDiffCallback()) {

    override fun getItemViewType(position: Int): Int = R.layout.adapter_game_item

    override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): UserListItemViewHolder {
        val view = parent.inflate(layoutId)
        return UserListItemViewHolder(AdapterUserListItemBinding.bind(view))
    }

    fun addUsers(users: List<UserDataUi>) {
        submitList(users.map { user -> UserListItem(user) })
    }
}