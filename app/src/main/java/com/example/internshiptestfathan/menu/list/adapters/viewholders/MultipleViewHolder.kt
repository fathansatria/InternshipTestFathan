package com.example.internshiptestfathan.menu.list.adapters.viewholders

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.internshiptestfathan.databinding.ItemImageMultipleBinding
import com.example.internshiptestfathan.databinding.ItemMultipleBinding
import com.example.internshiptestfathan.menu.list.adapters.ViewPagerAdapter
import com.example.internshiptestfathan.menu.list.models.PlaceModel
import com.example.internshiptestfathan.menu.list.viewmodels.ItemMultipleViewModel
import com.example.internshiptestfathan.menu.list.views.FragmentMainDirections

class MultipleViewHolder(val binding: ItemMultipleBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(placeModel: PlaceModel){

        binding.place = ItemMultipleViewModel(placeModel)


        if(placeModel.media != null){
            binding.vpMultiple.adapter = ViewPagerAdapter(binding, placeModel)
        }

        binding.root.setOnClickListener {
            openDetail(it, placeModel)
        }

        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): MultipleViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemMultipleBinding = ItemMultipleBinding.inflate(inflater, parent, false)
            return MultipleViewHolder(binding)
        }
    }

    private fun openDetail(view: View, placeModel: PlaceModel) {
        val action = FragmentMainDirections.actionToFragmentMultipleDetail()
        action.dataPlace = placeModel
        view.findNavController().navigate(action)
    }

}