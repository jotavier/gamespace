package com.picpay.desafio.android.main.presentation.ui.main.adapters.viewholders

import com.picpay.desafio.android.base.viewholder.BaseViewHolder
import com.picpay.desafio.android.main.R
import com.picpay.desafio.android.main.databinding.AdapterUserListItemBinding
import com.picpay.desafio.android.main.presentation.dataui.UserDataUi
import com.picpay.desafio.android.main.presentation.ui.main.adapters.listitems.UserListItem

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