package com.picpay.desafio.android.main.presentation.ui.main.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.picpay.desafio.android.main.presentation.ui.main.adapters.listitems.UserListItem

class UserListItemDiffCallback : DiffUtil.ItemCallback<UserListItem>() {

    override fun areItemsTheSame(
        oldItem: UserListItem,
        newItem: UserListItem
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: UserListItem,
        newItem: UserListItem
    ): Boolean = oldItem == newItem
}