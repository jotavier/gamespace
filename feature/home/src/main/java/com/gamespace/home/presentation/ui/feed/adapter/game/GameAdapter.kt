package com.gamespace.home.presentation.ui.feed.adapter.game

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.gamespace.core.extensions.inflate
import com.gamespace.home.R
import com.gamespace.home.presentation.ui.feed.adapter.game.diffutil.GameItemDiffCallback
import com.gamespace.home.presentation.ui.feed.adapter.viewholders.GameViewHolder

class GameAdapter : ListAdapter<GameDataUi, GameViewHolder>
    (GameItemDiffCallback()) {

    override fun getItemViewType(position: Int): Int =
        R.layout.adapter_game_item

    override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): GameViewHolder =
        GameViewHolder(AdapterGameItemBinding.bind(parent.inflate(layoutId)))
}
