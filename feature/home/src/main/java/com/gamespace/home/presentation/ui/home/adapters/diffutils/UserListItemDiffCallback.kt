package com.gamespace.home.presentation.ui.home.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.gamespace.home.presentation.ui.home.adapters.listitems.UserListItem

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