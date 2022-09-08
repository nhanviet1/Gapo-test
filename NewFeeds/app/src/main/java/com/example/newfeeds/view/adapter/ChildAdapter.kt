package com.example.newfeeds.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newfeeds.R
import com.example.newfeeds.databinding.ImageItemLayoutBinding
import com.example.newfeeds.model.MediaData

class ChildAdapter(private val list: List<MediaData>): RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindData(data: MediaData, position: Int){
            val binding = ImageItemLayoutBinding.bind(itemView)
            Glide.with(itemView.context).load(data.src).into(binding.image)
//            binding.image.setImageResource(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[holder.bindingAdapterPosition], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}