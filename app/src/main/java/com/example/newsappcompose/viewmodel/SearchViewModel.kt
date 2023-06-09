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
class SearchViewModel @Inject constructor(
    private val repository: NewsRepository
):ViewModel() {

    var searchedNewsList = mutableStateOf<List<Article>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)



    fun loadSearchedNews(searchQuery: String){
        viewModelScope.launch {
            isLoading.value= true
            val result = repository.getSearchNews(searchQuery)

            when(result){
                is Resource.Success ->{
                    val searchedNews = result.data!!.body().apply {
                        this!!.articles
                    }
                    errorMessage.value = ""
                    isLoading.value = false
                    searchedNewsList.value = searchedNews!!.articles
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                else->{
                    println("Error in loadSearchNews")
                }
            }
        }
    }
}