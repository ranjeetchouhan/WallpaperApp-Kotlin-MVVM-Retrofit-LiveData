package com.guysapp.wallpapers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.guysapp.wallpapers.model.DataItem
import com.guysapp.wallpapers.repository.ImageRepository

class MainActivityViewModel : ViewModel()  {


      val articleRepository: ImageRepository
     val  articleResponseLiveData: LiveData<List<DataItem>>
    init {

        articleRepository = ImageRepository()
        this.articleResponseLiveData =
            articleRepository.getImagesList()

    }

    fun getImageData(): LiveData<List<DataItem>> {
        return articleResponseLiveData
    }


}