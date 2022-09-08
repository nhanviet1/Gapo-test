package com.example.newfeeds.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.newfeeds.databinding.ActivityMainBinding
import com.example.newfeeds.fakedata.FakeList
import com.example.newfeeds.model.Data
import com.example.newfeeds.view.adapter.ParentAdapter
import com.example.newfeeds.viewmodel.GapoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ParentAdapter
    private var data2 = ArrayList<Data>()
    private val viewModel: GapoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        val data = FakeList().fakeData()
        viewModel.abc()
        viewModel.news.observe(this) {
            Log.d("Cat", "Hehe")
            data2.addAll(it.data)
            Glide.with(this).load(it.data[0].user.avatar).into(binding.fakeAvt)
            adapter = ParentAdapter(data2, data, this, object : ParentAdapter.CallBack {
                override fun onClickItem(position: Int) {
                    startActivity(Intent(this@MainActivity, MainActivity2::class.java))
                }
            })
            binding.recyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.adapter = adapter
        }
    }

}