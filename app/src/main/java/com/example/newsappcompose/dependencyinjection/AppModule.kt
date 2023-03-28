package com.example.newsappcompose.dependencyinjection

import com.example.newsappcompose.repository.NewsRepository
import com.example.newsappcompose.service.NewsAPI
import com.example.newsappcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.components.ViewWithFragmentComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    //In this way, it can be easily injected into the viewmodel.
    @Singleton
    @Provides
    fun provideNewsRepository(
        api: NewsAPI
    )= NewsRepository(api)



    @Singleton
    @Provides
    fun provideNewsApi(): NewsAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(NewsAPI::class.java)
    }


}