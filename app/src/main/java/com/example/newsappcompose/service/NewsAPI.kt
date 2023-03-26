package com.example.newsappcompose.service

import com.example.newsappcompose.model.NewsModel
import com.example.newsappcompose.util.Constants.API_KEY
import com.example.newsappcompose.util.Resource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    //https://newsapi.org/v2/everything?q=Apple&from=2023-03-25&sortBy=popularity&apiKey=d78074c607ce4e3dbcac74b29a07df19
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY

    //for ListScreen
    @GET("v2/top-headlines")
    fun getAllNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber : Int = 1,
        @Query("apiKey")
        apiKEy: String = API_KEY
    ): NewsModel


    //for SearchScreen
    @GET("v2/everything")
    fun getSearchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber : Int = 1,
        @Query("apiKey")
        apiKEy: String = API_KEY
    ): NewsModel

}