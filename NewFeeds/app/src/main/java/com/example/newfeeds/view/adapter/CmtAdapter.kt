package com.example.newfeeds.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newfeeds.R
import com.example.newfeeds.databinding.CmtLayoutBinding
import com.example.newfeeds.gone
import com.example.newfeeds.model.Comment
import com.example.newfeeds.visible
import java.text.SimpleDateFormat
import java.util.*

class CmtAdapter(private val list: List<Comment>) : RecyclerView.Adapter<CmtAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(data: Comment, position: Int) {
            val binding = CmtLayoutBinding.bind(itemView)
            binding.cmtText.text = data.content
            binding.name.text = data.user.display_name
            val avt = binding.avt
            Glide.with(itemView.context).load(data.user.avatar).into(avt)

            if (data.counts.reply_count > 0) {
                binding.replyNum.visible()
                binding.replyNum.text = itemView.context.getString(
                    R.string.reply_count,
                    data.counts.reply_count.toString()
                )
            } else {
                binding.replyNum.gone()
            }

            val itemLong:Long = (data.create_time.toLong()/ 1000)
            val d = Date(itemLong * 1000L)
            val itemDateStr: String = SimpleDateFormat("dd-MMM HH:mm").format(d)
            binding.time.text = itemDateStr
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cmt_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[holder.bindingAdapterPosition], position)
    }

    override fun getItemCount(): Int {
        if (list.size > 1 || list.size == 1) {
            return 1
        }
        return 0
    }
}