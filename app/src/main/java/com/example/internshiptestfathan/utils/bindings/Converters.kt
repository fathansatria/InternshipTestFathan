package com.example.internshiptestfathan.utils.bindings

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.GenericTransitionOptions
import com.example.internshiptestfathan.R
import com.example.internshiptestfathan.utils.bindings.glide.GlideApp
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("setAvatar")
fun CircleImageView.setAvatar(imageUrl: String?) {
    GlideApp.with(this)
        .load(imageUrl)
        .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
        .placeholder(R.drawable.placeholder_user)
        .error(R.drawable.placeholder_user)
        .into(this)
}

@BindingAdapter("setImageUrl")
fun AppCompatImageView.setImageUrl(imageUrl: String?) {
    GlideApp.with(this)
        .load(imageUrl)
        .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
        .placeholder(R.drawable.placeholder_image)
        .error(R.drawable.placeholder_image)
        .into(this)
}