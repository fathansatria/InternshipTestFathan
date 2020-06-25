package com.example.internshiptestfathan.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel
import com.example.internshiptestfathan.menu.list.models.HeaderModel
import com.example.internshiptestfathan.menu.list.models.PlaceModel

object AdapterCallback {

    val DiffListPlaceCallback = object : DiffUtil.ItemCallback<Any>() {

        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            if (oldItem is HeaderModel && newItem is HeaderModel) {
                return oldItem.title == newItem.title
            } else if (oldItem is PlaceModel && newItem is PlaceModel) {
                return oldItem.id == newItem.id
            } else {
                return true
            }
        }

    }

    val DiffGalleryCallback = object : DiffUtil.ItemCallback<GalleryModel>() {

        override fun areItemsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
            return oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
            return oldItem == newItem
        }

    }

    val imageCallback = object : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }
}