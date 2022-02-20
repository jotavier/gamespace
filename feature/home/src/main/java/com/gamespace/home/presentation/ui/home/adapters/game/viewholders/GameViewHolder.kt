package com.gamespace.home.presentation.ui.home.adapters.game.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.gamespace.core.extensions.hide
import com.gamespace.core.extensions.loadFrom
import com.gamespace.home.databinding.AdapterGameItemBinding
import com.gamespace.home.presentation.dataui.GameDataUi

class GameViewHolder(
    private val binding: AdapterGameItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(game: GameDataUi) = with(binding) {
        cover.loadFrom(game.coverUrl) { loadingCover.root.hide() }
    }
}