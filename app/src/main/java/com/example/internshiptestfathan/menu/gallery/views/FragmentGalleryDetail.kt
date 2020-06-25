package com.example.internshiptestfathan.menu.gallery.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.internshiptestfathan.databinding.FragmentGalleryDetailBinding
import com.example.internshiptestfathan.menu.gallery.models.GalleryModel
import com.example.internshiptestfathan.menu.gallery.viewmodels.GalleryDetailViewModel
import com.example.internshiptestfathan.utils.ViewModelFragmentFactory

class FragmentGalleryDetail: Fragment() {

    private val args: FragmentGalleryDetailArgs by navArgs()
    private lateinit var binding: FragmentGalleryDetailBinding
    private val viewModel: GalleryDetailViewModel by viewModels { ViewModelFragmentFactory(args.dataGallery as GalleryModel) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGalleryDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gallery = viewModel
    }

}