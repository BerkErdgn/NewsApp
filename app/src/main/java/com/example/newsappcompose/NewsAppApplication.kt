package com.example.newsappcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


//if you use hilt, you have to add this
@HiltAndroidApp
class NewsAppApplication : Application(){
}