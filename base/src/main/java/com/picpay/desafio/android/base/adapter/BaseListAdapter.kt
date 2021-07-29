package com.picpay.desafio.android.base.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.picpay.desafio.android.base.viewholder.BaseViewHolder

abstract class BaseListAdapter<ITEM, VIEWHOLDER : BaseViewHolder<ITEM>>(
    diffUtil: DiffUtil.ItemCallback<ITEM>
) : ListAdapter<ITEM, VIEWHOLDER>(diffUtil) {

    override fun onBindViewHolder(holder: VIEWHOLDER, position: Int) =
        holder.bind(getItem(position))
}