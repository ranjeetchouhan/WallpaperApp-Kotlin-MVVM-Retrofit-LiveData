package com.guysapp.wallpapers.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.guysapp.wallpapers.model.DataItem
import com.guysapp.wallpapers.model.ResponseModel
import com.guysapp.wallpapers.utils.RetrofitClientInstance
import com.guysapp.wallpapers.utils.endpoints
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageRepository {

    lateinit var imageList : MutableLiveData<List<DataItem>>
    private val TAG = ImageRepository::class.java!!.getSimpleName()
    private val apiRequest: endpoints



    init {

        apiRequest = RetrofitClientInstance.getRetrofitInstance().create(endpoints::class.java)
    }
    fun getImagesList() : LiveData<List<DataItem>>{

        imageList = MutableLiveData()

        apiRequest.images.enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                Log.d(TAG,response.code().toString())
                imageList.value = response.body()!!.dataItem.toMutableList()
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

              }
        })
        return imageList
    }
}