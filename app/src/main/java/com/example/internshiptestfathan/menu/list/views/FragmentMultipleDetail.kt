package com.example.internshiptestfathan.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.internshiptestfathan.databinding.FragmentMultipleDetailBinding
import com.example.internshiptestfathan.menu.list.adapters.ViewPagerDetailAdapter
import com.example.internshiptestfathan.menu.list.models.PlaceModel
import com.example.internshiptestfathan.menu.list.viewmodels.MultipleDetailViewModel
import com.example.internshiptestfathan.utils.ViewModelFragmentFactory
import com.example.internshiptestfathan.utils.anim.ParallaxPageTransformer


class FragmentMultipleDetail: Fragment() {

    private val args: FragmentMultipleDetailArgs by navArgs()
    private lateinit var binding: FragmentMultipleDetailBinding
    private val viewModel: MultipleDetailViewModel by viewModels{ ViewModelFragmentFactory(args.dataPlace as PlaceModel) }

    private lateinit var viewPagerAdapter: ViewPagerDetailAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMultipleDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.place = viewModel
        setupMultipleImage()
    }

    private fun setupMultipleImage() {
        args.dataPlace?.media?.let {
            viewPagerAdapter = ViewPagerDetailAdapter(childFragmentManager, it)
            binding.viewPager.adapter = viewPagerAdapter
            binding.viewPager.setPageTransformer(false, ParallaxPageTransformer())
            binding.dotsIndicator.setViewPager(binding.viewPager)
        }
    }

}