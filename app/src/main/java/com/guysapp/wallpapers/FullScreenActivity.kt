package com.guysapp.wallpapers

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_fullscreen.*

class FullScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_fullscreen)

//        var previewURL = intent.getStringExtra("url")
//
//
//        Picasso.with(this).load(previewURL)
//            .placeholder(R.drawable.download).into(image_fullscreen)

    }
}