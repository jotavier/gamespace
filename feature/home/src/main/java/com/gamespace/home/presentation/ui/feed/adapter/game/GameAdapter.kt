package com.gamespace.home.presentation.ui.feed.adapter.game

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.gamespace.common.presentation.dataui.GameDataUi
import com.gamespace.core.extensions.inflate
import com.gamespace.home.R
import com.gamespace.home.databinding.AdapterGameItemBinding
import com.gamespace.home.databinding.HomeAdapterGameItemBinding
import com.gamespace.home.presentation.ui.feed.adapter.game.diffutil.GameItemDiffCallback
import com.gamespace.home.presentation.ui.feed.adapter.game.viewholder.GameViewHolder

class GameAdapter : ListAdapter<GameDataUi, GameViewHolder>
    (GameItemDiffCallback()) {

    override fun getItemViewType(position: Int): Int =
        R.layout.home_adapter_game_item

    override fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): GameViewHolder =
        GameViewHolder(HomeAdapterGameItemBinding.bind(parent.inflate(layoutId)))
}
