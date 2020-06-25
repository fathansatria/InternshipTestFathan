package com.example.internshiptestfathan.menu.list.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshiptestfathan.databinding.ItemHeaderBinding
import com.example.internshiptestfathan.menu.list.models.HeaderModel
import com.example.internshiptestfathan.menu.list.viewmodels.ItemHeaderViewModel

class HeaderViewHolder(val binding: ItemHeaderBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(header: HeaderModel) {
        binding.header = ItemHeaderViewModel(header)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): HeaderViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemHeaderBinding = ItemHeaderBinding.inflate(inflater, parent, false)
            return HeaderViewHolder(
                binding
            )
        }
    }

}