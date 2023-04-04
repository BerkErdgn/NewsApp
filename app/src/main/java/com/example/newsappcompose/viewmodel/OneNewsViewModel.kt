package com.example.newsappcompose.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.model.Article
import com.example.newsappcompose.model.NewsModel
import com.example.newsappcompose.repository.NewsRepository
import com.example.newsappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class OneNewsViewModel @Inject constructor(
    private val repository: NewsRepository
):ViewModel() {

        suspend fun getOneNews(newsContentQuery: String): Resource<NewsModel>{
            return repository.getOneNews(newsContentQuery)
        }




}

    /*
    var oneNewsArticle = mutableStateOf<List<Article>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)


    fun oneNews (newsContentQuery: String){
        viewModelScope.launch {
            isLoading.value= true
            val result = repository.getOneNews(newsContentQuery)

            when(result){
                is Resource.Success->{
                    val oneNews = result.data!!.body().apply {
                        this!!.articles
                    }
                    errorMessage.value=""
                    isLoading.value = false
                    oneNewsArticle.value = oneNews!!.articles

                }
                is Resource.Error->{
                    errorMessage.value= result.message!!
                    isLoading.value=false
                }
                else->{
                    println("Error in oneNews")
                }
            }
        }
    }




     */

