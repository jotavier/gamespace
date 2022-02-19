package com.gamespace.home.presentation.ui.home.adapters.viewholders

import com.picpay.desafio.gamespace.base.extensions.hide
import com.picpay.desafio.gamespace.base.extensions.loadFromUrl
import com.picpay.desafio.gamespace.base.extensions.show
import com.picpay.desafio.gamespace.base.viewholder.BaseViewHolder
import com.picpay.desafio.gamespace.home.R
import com.picpay.desafio.gamespace.home.databinding.AdapterUserListItemBinding
import com.gamespace.home.presentation.dataui.UserDataUi
import com.gamespace.home.presentation.ui.home.adapters.listitems.UserListItem

class UserListItemViewHolder(
    private val binding: AdapterUserListItemBinding
) : BaseViewHolder<UserListItem>(binding) {

    override fun bind(item: UserListItem) {
        setupUserAttributes(item.user)
    }

    private fun setupUserAttributes(user: UserDataUi) = binding.run {
        name.text = user.name
        userName.text = user.userName
        picture.loadFromUrl(
            imageUrl = user.img,
            errorDrawableId = R.drawable.ic_round_account_circle,
            onStart = { progressBar.show() },
            onError = { progressBar.hide() },
            onSuccess = { progressBar.hide() }
        )
    }
}