package com.example.internshiptestfathan.menu.list.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.viewpager.widget.PagerAdapter
import com.example.internshiptestfathan.databinding.ItemImageMultipleBinding
import com.example.internshiptestfathan.databinding.ItemMultipleBinding
import com.example.internshiptestfathan.menu.list.models.PlaceModel
import com.example.internshiptestfathan.menu.list.viewmodels.ItemImageMultipleViewModel
import com.example.internshiptestfathan.menu.list.views.FragmentMainDirections

class ViewPagerAdapter(val binding: ItemMultipleBinding, private val placeModel : PlaceModel) : PagerAdapter() {

    private lateinit var itemBinding: ItemImageMultipleBinding

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater  = LayoutInflater.from(container.context)
        itemBinding = ItemImageMultipleBinding.inflate(inflater, container, false)

        if(placeModel.media != null){
            itemBinding.image = ItemImageMultipleViewModel(placeModel.media[position])
        }

        itemBinding.ivImg.setOnClickListener {
            openDetail(binding.root, placeModel)
        }

        container.addView(itemBinding.root)
        return itemBinding.root
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return placeModel.media!!.size
    }

    override fun getPageWidth(position: Int): Float {
        return 0.90f
    }

    private fun openDetail(view: View, placeModel: PlaceModel) {
        val action = FragmentMainDirections.actionToFragmentMultipleDetail()
        action.dataPlace = placeModel
        view.findNavController().navigate(action)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }


}