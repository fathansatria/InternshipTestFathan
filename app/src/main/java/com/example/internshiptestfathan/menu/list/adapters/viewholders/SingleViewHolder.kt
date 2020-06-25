package com.example.internshiptestfathan.menu.list.adapters.viewholders

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.internshiptestfathan.databinding.ItemSingleBinding
import com.example.internshiptestfathan.menu.list.models.PlaceModel
import com.example.internshiptestfathan.menu.list.viewmodels.ItemSingleViewModel
import com.example.internshiptestfathan.menu.list.views.FragmentMainDirections

class SingleViewHolder(val binding: ItemSingleBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(placeModel: PlaceModel) {
        binding.place = ItemSingleViewModel(placeModel)
        binding.root.setOnClickListener {
            val action = FragmentMainDirections.actionToFragmentSingleDetail()
            action.dataPlace = placeModel
            it?.findNavController()?.navigate(action)
        }
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): SingleViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemSingleBinding = ItemSingleBinding.inflate(inflater, parent, false)
            return SingleViewHolder(binding)
        }
    }

}