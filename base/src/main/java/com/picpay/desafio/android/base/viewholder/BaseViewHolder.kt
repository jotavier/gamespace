package com.picpay.desafio.android.base.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T>(
    private val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    protected val context: Context by lazy { binding.root.context }
    open fun bind(item: T): Unit = Unit
}