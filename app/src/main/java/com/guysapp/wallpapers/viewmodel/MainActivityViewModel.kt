package com.guysapp.wallpapers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.guysapp.wallpapers.model.Hit
import com.guysapp.wallpapers.repository.ImageRepository

class MainActivityViewModel : ViewModel()  {


      val articleRepository: ImageRepository
     val  articleResponseLiveData: LiveData<List<Hit>>
    init {

        articleRepository = ImageRepository()
        this.articleResponseLiveData =
            articleRepository.getImagesList()

    }

    fun getImageData(): LiveData<List<Hit>> {
        return articleResponseLiveData
    }


}