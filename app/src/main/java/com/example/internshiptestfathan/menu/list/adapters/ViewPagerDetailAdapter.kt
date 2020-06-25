package com.example.internshiptestfathan.menu.list.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.internshiptestfathan.menu.list.views.FragmentImage

class ViewPagerDetailAdapter(fragmentManager: FragmentManager, private val listImage: MutableList<String?>): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return FragmentImage.getInstance(listImage[position])
    }

    override fun getCount(): Int {
        return listImage.size
    }
}