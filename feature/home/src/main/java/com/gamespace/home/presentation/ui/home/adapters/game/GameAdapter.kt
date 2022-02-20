package com.gamespace.home.presentation.ui.home.adapters.game

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.gamespace.core.extensions.inflate
import com.gamespace.home.R
import com.gamespace.home.presentation.ui.home.adapters.game.diffutils.GameItemDiffCallback
import com.gamespace.home.presentation.ui.home.adapters.listitems.GameItem
import com.gamespace.home.presentation.ui.home.adapters.viewholders.GameViewHolder

class GameAdapter : ListAdapter<GameDataUi, GameViewHolder>
    (GameItemDiffCallback()) {

    override fun getItemViewType(position: Int): Int =
        R.layout.adapter_game_item

    override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): GameViewHolder =
        GameViewHolder(AdapterGameItemBinding.bind(parent.inflate(layoutId)))
}
