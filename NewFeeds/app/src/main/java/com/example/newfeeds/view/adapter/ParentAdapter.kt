package com.example.newfeeds.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.example.newfeeds.R
import com.example.newfeeds.databinding.ParentRecyclerLayoutBinding
import com.example.newfeeds.gone
import com.example.newfeeds.invisible
import com.example.newfeeds.model.Data
import com.example.newfeeds.visible
import java.text.SimpleDateFormat
import java.util.*

class ParentAdapter(
    private val list: List<Data>,
    private val listChild: List<Int>,
    private val context: Context,
    private val callback: CallBack
): RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SimpleDateFormat")
        fun bindData(data: Data, position: Int){
            val binding = ParentRecyclerLayoutBinding.bind(itemView)
            binding.name.text = data.user.display_name
            binding.content.text = data.content

            binding.numOfReact.text = data.counts.react_count.toString()

            val avt = binding.avt
            Glide.with(context).load(data.user.avatar).into(avt)
            Glide.with(context).load(data.user.avatar).into(binding.avtCmt)

            val itemLong:Long = (data.create_time.toLong() / 1000)
            val d = Date(itemLong * 1000L)
            val itemDateStr: String = SimpleDateFormat("dd-MMM HH:mm").format(d)
            binding.time.text = itemDateStr

            binding.numOfCmt.text = context.getString(R.string.like_count, data.counts.comment_count.toString())
            binding.numOfShare.text = context.getString(R.string.share_count, data.counts.share_count.toString())

            if (data.mediaData.isNotEmpty() && data.mediaData[0].type == "image" ){
                if (data.mediaData.size == 1){
                    binding.singleImg.visible()
                    binding.imageRecyclerView.gone()
                    Glide.with(context).load(data.mediaData[0].src).into(binding.singleImg)
                } else {
                    binding.singleImg.invisible()
                    binding.imageRecyclerView.visible()
//                    Glide.with(context).load(data.mediaData[0].src).into(binding.doubleImg1)
//                    Glide.with(context).load(data.mediaData[1].src).into(binding.doubleImg2)
                    val adapter = ChildAdapter(data.mediaData)
                    binding.imageRecyclerView.layoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
                    binding.imageRecyclerView.adapter = adapter
                }
            } else {
                binding.singleImg.gone()
                binding.imageRecyclerView.gone()
                binding.doubleImg1.gone()
                binding.doubleImg2.gone()
            }


            val cmtAdapter = CmtAdapter(data.comments)
            binding.rvCmt.layoutManager = LinearLayoutManager(context)
            binding.rvCmt.adapter = cmtAdapter

            binding.root.setOnClickListener {
                callback.onClickItem(position)
            }
        }
    }

    interface CallBack{
        fun onClickItem(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[holder.bindingAdapterPosition], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}