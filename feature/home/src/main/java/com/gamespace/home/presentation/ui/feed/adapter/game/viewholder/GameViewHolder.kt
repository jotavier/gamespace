package com.gamespace.home.presentation.ui.feed.adapter.game.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.gamespace.common.presentation.dataui.GameDataUi
import com.gamespace.core.extensions.disable
import com.gamespace.core.extensions.loadFrom
import com.gamespace.home.databinding.AdapterGameItemBinding

class GameViewHolder(
    private val binding: AdapterGameItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(game: GameDataUi) = with(binding) {
        cover.loadFrom(game.coverUrl) { loadingCover.root.disable() }
    }
}