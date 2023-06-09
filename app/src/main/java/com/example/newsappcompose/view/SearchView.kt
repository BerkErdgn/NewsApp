package com.example.newsappcompose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsappcompose.viewmodel.SearchViewModel

@Composable
fun NewsSearchScreen(navController: NavController,viewModel: SearchViewModel= hiltViewModel()){

    Surface(modifier = Modifier.fillMaxSize()) {

        Column {
            Spacer(modifier = Modifier.height(10.dp))

            SearchBar(hint = "Search news...", modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)){
                viewModel.loadSearchedNews(it)
            }
            Spacer(modifier = Modifier.height(10.dp))

            SearchView(navController = navController)
        }
    }

}



@Composable
fun SearchView (navController: NavController,viewModel: SearchViewModel = hiltViewModel()) {
    val searchedNewsList by remember { viewModel.searchedNewsList }
    val errorMessage by remember {viewModel.errorMessage }
    val isLoading by remember {viewModel.isLoading}

    NewsListView(articles = searchedNewsList, navController = navController)

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        if(isLoading){
            CircularProgressIndicator(color = Color.Red)
        }
        if (errorMessage.isNotEmpty()){
            println(errorMessage)
        }
    }
}



@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint : String = "",
    onSearch : (String) -> Unit = {}
){

    var text by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }

    Box(modifier = modifier){
        BasicTextField(value = text,
            onValueChange = {
                if(it.isNotEmpty()){
                    text = it
                    onSearch(it)
                }else{
                    text=""
                    println("boş")
                }

            }, maxLines = 1,
            singleLine = true,
            textStyle = TextStyle.Default,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(7.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 30.dp, vertical = 15.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                })

        if (isHintDisplayed){
            Text(text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(20.dp))
        }
    }
}