package com.example.internshiptestfathan.menu.list.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.internshiptestfathan.databinding.FragmentMainBinding
import com.example.internshiptestfathan.main.views.MainActivity
import com.example.internshiptestfathan.menu.list.adapters.MainAdapter
import com.example.internshiptestfathan.menu.list.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentMain : Fragment() {

    private lateinit var binding : FragmentMainBinding

    var allData = ArrayList<Any>()

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.i("ADA", "TIDAK NULL")

//        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
//        activity?.tv_toolbar?.text = "list"

        viewModel.setData()
        setupRecyclerView()


    }

    private fun setupRecyclerView() {

        viewModel.getAllData().observe(viewLifecycleOwner, Observer {

            if(it != null){

                allData.add(it.header!!)
                allData.addAll(it.content!!)

                val mainAdapter =
                    MainAdapter(
                        requireActivity(),
                        allData
                    )

                rv_main.adapter = mainAdapter

//                mainAdapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback {
//                    override fun onItemClicked(data: Any) {
//                        if(data is Content){
//                            val intent = Intent(activity, DetailActivity::class.java)
//                            intent.putExtra("item", data)
//                            startActivity(intent)
//                        }
//
//                    }
//                })

            }


        })

    }

}