package com.gamespace.home.presentation.ui.feed.adapter.game.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gamespace.home.presentation.dataui.GameDataUi

class GameItemDiffCallback : DiffUtil.ItemCallback<GameDataUi>() {

    override fun areItemsTheSame(
        oldItem: GameDataUi,
        newItem: GameDataUi
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: GameDataUi,
        newItem: GameDataUi
    ): Boolean = oldItem == newItem
}