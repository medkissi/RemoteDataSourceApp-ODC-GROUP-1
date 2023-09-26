package com.medkissi.remote.ui

import android.annotation.SuppressLint
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medkissi.remote.R
import com.medkissi.remote.adapters.PhotoAdapter
import com.medkissi.remote.adapters.PostAdapter
import com.medkissi.remote.viewmodels.PostViewModel

class MainActivity : AppCompatActivity(){
    val viewModel:PostViewModel by viewModels()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView  = findViewById<RecyclerView>(R.id.rv)
        val layoutManager = LinearLayoutManager(this)
        val adapter =  PhotoAdapter()
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter=  adapter
        val progress = findViewById<ProgressBar>(R.id.progressBar)

        viewModel.getData().observe(this){ state ->
            when(state){
                is Resource.Error -> TODO()
                is Resource.Loading -> {progress.visibility= View.VISIBLE}
                is Resource.Success -> {
                    adapter.submitList(state.data)
                    progress.visibility =View.GONE
                }
            }



        }
    }
}