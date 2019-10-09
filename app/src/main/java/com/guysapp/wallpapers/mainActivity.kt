package com.guysapp.wallpapers

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.guysapp.wallpapers.adapter.CustomAdapter
import com.guysapp.wallpapers.model.DataItem
import com.guysapp.wallpapers.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class mainActivity : AppCompatActivity() {


     lateinit var articleViewModel: MainActivityViewModel
    lateinit var mAdapter: CustomAdapter
    lateinit var imageList : ArrayList<DataItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()

        getImageData()
    }


    fun initialization(){

        imageList = ArrayList()
        mAdapter = CustomAdapter(this,imageList)

        simpleGridView.adapter = mAdapter

        articleViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }


    fun getImageData(){


        articleViewModel.getImageData().observe(this, Observer {
            imageList.addAll(it)
            mAdapter.notifyDataSetChanged()
            Log.d("MainActivity",it.size.toString())
        })

    }
}