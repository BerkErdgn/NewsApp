package com.example.newsappcompose.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsappcompose.model.RoomModel

@Database(entities = [RoomModel::class], version = 1)
abstract class NewsDatabase : RoomDatabase(){
    abstract fun newsDao(): NewsDao
}