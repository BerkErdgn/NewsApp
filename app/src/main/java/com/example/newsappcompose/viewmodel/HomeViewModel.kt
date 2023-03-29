package com.example.newsappcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.model.Article
import com.example.newsappcompose.repository.NewsRepository
import com.example.newsappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : NewsRepository
) : ViewModel() {

        var newsList = mutableStateOf<List<Article>>(listOf())
        var errorMessage = mutableStateOf("")
        var isLoading = mutableStateOf(false)

    init {
        loadNews()
    }
    fun loadNews(){
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getNewsList()
            when(result){
                is Resource.Success -> {

                    val news = result.data!!.body().apply {
                        this!!.articles
                    }

                 /*  val news = result.data!!.articles.mapIndexed { index, article ->
                       Article(article.author,article.content,article.description,article.publishedAt,article.source,article.title,article.url,article.urlToImage)

                   }
                  */
                    errorMessage.value=""
                    isLoading.value=false
                    newsList.value = news!!.articles

                }
                is Resource.Error -> {
                    errorMessage.value= result.message!!
                    isLoading.value=false
                }

                else -> {
                    println("Error loadNews")
                }
            }

        }

    }




}