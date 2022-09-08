package com.example.newfeeds.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.newfeeds.R
import com.example.newfeeds.databinding.ActivityMain2Binding
import com.example.newfeeds.view.adapter.CmtAdapter2
import com.example.newfeeds.view.adapter.ImgDetailAdapter
import com.example.newfeeds.viewmodel.GapoViewModel

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: ImgDetailAdapter
    private lateinit var adapter2: CmtAdapter2
    private val viewModel: GapoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        binding.back.setOnClickListener {
            onBackPressed()
        }
        viewModel.xyz()
        viewModel.detail.observe(this){
            Glide.with(this).load(it.user.avatar).into(binding.avt)
            binding.content.text = it.content
            binding.numOfReact.text = it.counts.react_count.toString()
            binding.numOfCmt.text = getString(R.string.like_count, it.counts.comment_count.toString())
            binding.numOfShare.text = getString(R.string.share_count, it.counts.share_count.toString())
            adapter = ImgDetailAdapter(it.mediaData)
            binding.imageRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.imageRecyclerView.adapter = adapter

            adapter2 = CmtAdapter2(it.comments)
            binding.rvCmt.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.rvCmt.adapter = adapter2
        }
    }
}