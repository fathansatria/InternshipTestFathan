package com.example.internshiptestfathan.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.internshiptestfathan.databinding.FragmentSingleDetailBinding
import com.example.internshiptestfathan.menu.list.models.PlaceModel
import com.example.internshiptestfathan.menu.list.viewmodels.SingleDetailViewModel
import com.example.internshiptestfathan.utils.ViewModelFragmentFactory

class FragmentSingleDetail: Fragment() {

    private val args: FragmentSingleDetailArgs by navArgs()
    private lateinit var binding: FragmentSingleDetailBinding
    private val viewModel: SingleDetailViewModel by viewModels { ViewModelFragmentFactory(args.dataPlace as PlaceModel) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSingleDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.place = viewModel
    }

}