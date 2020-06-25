package com.example.internshiptestfathan.menu.gallery.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.internshiptestfathan.menu.gallery.adapters.viewholders.GalleryViewHolder
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel
import com.example.internshiptestfathan.utils.AdapterCallback

class GalleryAdapter(val onItemClick:(GalleryModel) -> Unit): ListAdapter<GalleryModel, GalleryViewHolder>(
    AdapterCallback.DiffGalleryCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        holder.itemView.setOnClickListener {
            onItemClick(model)
        }
    }

}