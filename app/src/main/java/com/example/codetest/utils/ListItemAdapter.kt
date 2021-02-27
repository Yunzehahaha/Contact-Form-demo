package com.example.codetest.utils

import android.app.LauncherActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codetest.databinding.ListItemBinding
import com.example.codetest.model.DetailInfo

class ListItemAdapter (private val listItems: ArrayList<DetailInfo>) : RecyclerView.Adapter<ListItemAdapter.MyViewHolder>() {

    private var listener: OnItemClickListener? = null
    class MyViewHolder(var binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

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