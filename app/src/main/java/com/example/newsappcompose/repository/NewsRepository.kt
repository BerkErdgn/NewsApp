package com.example.newsappcompose.repository

import com.example.newsappcompose.model.NewsModel
import com.example.newsappcompose.service.NewsAPI
import com.example.newsappcompose.util.Constants.API_KEY
import com.example.newsappcompose.util.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton


@ActivityScoped
class NewsRepository @Inject constructor(
    private val api : NewsAPI
){
    suspend fun getNewsList(): Resource<NewsModel>{
        val response = try {
            api.getAllNews("us",API_KEY)
        }catch (e:Exception){
            return Resource.Error("NewsRepository-getNewsList doesn't work.")
        }

        return Resource.Success(response)
    }

    suspend fun getSearchNews(searchText : String): Resource<NewsModel>{
        val response = try {
            api.getSearchNews(searchText,1, API_KEY)
        }catch (e:Exception){
            return Resource.Error("NewsRepository-getSearchNews doesn't work.")
        }
        return Resource.Success(response)
    }

}