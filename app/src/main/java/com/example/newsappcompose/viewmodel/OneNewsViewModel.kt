package com.example.newsappcompose.viewmodel



import androidx.lifecycle.ViewModel
import com.example.newsappcompose.model.NewsModel
import com.example.newsappcompose.repository.NewsRepository
import com.example.newsappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OneNewsViewModel @Inject constructor(
    private val repository: NewsRepository
):ViewModel() {

        suspend fun getOneNews(newsContentQuery: String): Resource<NewsModel>{
            return repository.getOneNews(newsContentQuery)
        }
}


