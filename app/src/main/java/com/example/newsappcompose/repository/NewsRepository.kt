package com.example.newsappcompose.repository

import androidx.lifecycle.LiveData
import com.example.newsappcompose.model.NewsModel
import com.example.newsappcompose.model.RoomModel
import com.example.newsappcompose.roomdb.NewsDao
import com.example.newsappcompose.service.NewsAPI
import com.example.newsappcompose.util.Constants.API_KEY
import com.example.newsappcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import javax.inject.Inject


@ActivityScoped
class NewsRepository @Inject constructor(
    private val newsDao: NewsDao,
    private val api : NewsAPI
){

    //for retrofit
     suspend fun getNewsList(): Resource<Response<NewsModel>>{
        val response = try{
            api.getAllNews("us",1,API_KEY)
        }catch (e:Exception){
            return Resource.Error("NewsRepository-getNewsList doesn't work.")
        }

        return Resource.Success(response)
    }

     suspend fun getSearchNews(searchText : String): Resource<Response<NewsModel>>{

        val response = try {
            api.getSearchNews(searchText,1, API_KEY)
        }catch (e:Exception){
            return Resource.Error("NewsRepository-getSearchNews doesn't work.")
        }
        return Resource.Success(response)
    }


    suspend fun getOneNews(newsContentQuery : String): Resource<NewsModel>{
        val response = try {
            api.getOneNews(newsContentQuery,1, API_KEY)
        }catch (e:Exception){
            return Resource.Error("NewsRepository-getOneNews doesn't work.")
        }
        return  Resource.Success(response)
    }

    //for Room

    suspend fun insertNews(news: RoomModel){
        newsDao.insertNews(news)
    }

    suspend fun deleteNews(news: RoomModel){
        newsDao.deleteArt(news)
    }

     fun getNews(): LiveData<List<RoomModel>>{
        return newsDao.observeNews()
    }



}
