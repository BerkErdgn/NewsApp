package com.example.newsappcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newsappcompose.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : NewsRepository
) : ViewModel() {




}