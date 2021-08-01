package com.picpay.desafio.android.home.presentation.ui.home.adapters.viewholders

import com.picpay.desafio.android.base.viewholder.BaseViewHolder
import com.picpay.desafio.android.home.R
import com.picpay.desafio.android.home.databinding.AdapterUserListItemBinding
import com.picpay.desafio.android.home.presentation.dataui.UserDataUi
import com.picpay.desafio.android.home.presentation.ui.home.adapters.listitems.UserListItem

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