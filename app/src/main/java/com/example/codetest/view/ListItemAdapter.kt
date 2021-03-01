package com.example.codetest.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codetest.databinding.ListItemBinding
import com.example.codetest.model.DetailInfo

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.MyViewHolder>() {

    private val listItems =  ArrayList<DetailInfo>()
    private var listener: OnItemClickListener? = null
    class MyViewHolder(var binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun updateList(data: List<DetailInfo>) {
        listItems.clear()
        listItems.addAll(data)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.items = this.listItems[position]
        holder.itemView.setOnClickListener {
            listener?.onItemClick(it, listItems[position], position)
        }
    }

    override fun getItemCount() = listItems.size

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, value: DetailInfo, position: Int)
    }
}