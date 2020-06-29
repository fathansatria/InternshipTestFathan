package com.example.internshiptestfathan.menu.gallery.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.internshiptestfathan.databinding.FragmentGalleryBinding
import com.example.internshiptestfathan.menu.gallery.adapters.GalleryAdapter
import com.example.internshiptestfathan.menu.gallery.viewmodels.GalleryViewModel
import com.example.internshiptestfathan.utils.ViewModelFragmentFactory

class FragmentGallery : Fragment() {

    private val viewModel: GalleryViewModel by viewModels{ ViewModelFragmentFactory(context as Context) }
    private lateinit var binding :FragmentGalleryBinding
    private lateinit var galleryAdapter :GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gallery = viewModel

        viewModel.getGalleryData()
        setupRecyclerView()
        observeData()
    }


    private fun setupRecyclerView(){

        galleryAdapter = GalleryAdapter {
            val action = FragmentGalleryDirections.actionToFragmentGalleryDetail()
            action.dataGallery = it
            findNavController().navigate(action)
        }
        binding.rvGallery.apply {
            adapter = galleryAdapter
        }

    }

    private fun observeData(){
        viewModel.listGallery.observe(viewLifecycleOwner, Observer {
            galleryAdapter.submitList(it)

        })
    }

}