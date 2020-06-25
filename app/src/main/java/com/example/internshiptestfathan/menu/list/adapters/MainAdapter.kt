package com.example.internshiptestfathan.menu.list.adapters

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.internshiptestfathan.menu.list.adapters.viewholders.HeaderViewHolder
import com.example.internshiptestfathan.menu.list.adapters.viewholders.MultipleViewHolder
import com.example.internshiptestfathan.menu.list.adapters.viewholders.SingleViewHolder
import com.example.internshiptestfathan.menu.list.models.HeaderModel
import com.example.internshiptestfathan.menu.list.models.PlaceModel

class MainAdapter(var activity: Activity, var data : ArrayList<Any>) : RecyclerView.Adapter<ViewHolder>(){

    private val HEADER = 1
    private val SINGLE = 2
    private val MULTIPLE = 3

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return when(viewType){
            HEADER -> {
                HeaderViewHolder.from(parent)
            }
            SINGLE -> {
                SingleViewHolder.from(parent)
            }
            else -> {
                MultipleViewHolder.from(parent)
            }
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when(holder){
            is HeaderViewHolder -> {
                holder.bind(data[position] as HeaderModel)
            }
            is SingleViewHolder -> {
                holder.bind(data[position] as PlaceModel)
            }
            is MultipleViewHolder -> {
                holder.bind(data[position] as PlaceModel)
            }
        }

//        holder.itemView.setOnClickListener {
//            onItemClickCallback.onItemClicked(data[holder.adapterPosition])
//        }

    }

    override fun getItemViewType(position: Int): Int {

        var type = 0
        when(data[position]){
            is HeaderModel -> type = HEADER
            is PlaceModel -> {
                return if((data[position] as PlaceModel).type == "image"){
                    SINGLE
                } else{
                    MULTIPLE
                }
            }
        }

        return type
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Any)
    }


}