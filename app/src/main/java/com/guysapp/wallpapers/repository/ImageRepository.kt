package com.guysapp.wallpapers.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.guysapp.wallpapers.model.Hit
import com.guysapp.wallpapers.model.ResponsePixebay
import com.guysapp.wallpapers.utils.RetrofitClientInstance
import com.guysapp.wallpapers.utils.endpoints
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageRepository {

    lateinit var imageList : MutableLiveData<List<Hit>>
    private val TAG = ImageRepository::class.java!!.getSimpleName()
    private val apiRequest: endpoints



    init {

        apiRequest = RetrofitClientInstance.getRetrofitInstance().create(endpoints::class.java)
    }
    fun getImagesList() : LiveData<List<Hit>>{

        imageList = MutableLiveData()

        var queryMap = HashMap<String,String>()
        queryMap.put("key","13886168-989661838f8d04f0a6da3077e")
//        queryMap.put("q","nature")
        queryMap.put("image_type","photo")
        queryMap.put("category","travel")
        queryMap.put("per_page","200")


        apiRequest.getImages(queryMap).enqueue(object : Callback<ResponsePixebay>{
            override fun onResponse(call: Call<ResponsePixebay>, response: Response<ResponsePixebay>) {
                Log.d(TAG,response.code().toString())

//                imageList.value = response.body()!!.photos.toMutableList()
                    imageList.value = response.body()!!.hits.toMutableList()

            }

            override fun onFailure(call: Call<ResponsePixebay>, t: Throwable) {

              }
        })
        return imageList
    }
}