package com.example.newsappcompose.view


import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsappcompose.AppNameText
import com.example.newsappcompose.model.NewsModel
import com.example.newsappcompose.ui.theme.custemPink
import com.example.newsappcompose.ui.theme.customWhite
import com.example.newsappcompose.util.Resource
import com.example.newsappcompose.viewmodel.OneNewsViewModel
import com.example.newsappcompose.viewmodel.SavedNewsViewModel

@Composable
fun detailView(content: String,
    viewModel : OneNewsViewModel = hiltViewModel(),
    saveViewModel: SavedNewsViewModel = hiltViewModel()
               ){

    val oneNews = produceState<Resource<NewsModel>>(initialValue = Resource.Loading()){
        value = viewModel.getOneNews(content)
    }.value

    when(oneNews){
        is Resource.Success ->{
            if (oneNews.data!!.articles.isNotEmpty()){
                Column(modifier = Modifier.fillMaxSize()) {
                    AppNameText()
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp)){

                        //For we can see website in app directly
                        AndroidView(factory = {
                            WebView(it).apply {
                                layoutParams = ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT
                                )
                                webViewClient = WebViewClient()
                                loadUrl(oneNews.data!!.articles[0].url)
                            }
                        }, update = {
                            it.loadUrl(oneNews.data!!.articles[0].url)
                        })
                        Row(modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(5.dp)) {
                            val context = LocalContext.current
                            customFloatingButton {
                                Toast.makeText(context,"Successfully saved!",Toast.LENGTH_LONG).show()
                                val saveNews= oneNews.data!!.articles[0]
                                saveViewModel.saveNews(saveNews.author ?:"",saveNews.content?:"",saveNews.description?:"",saveNews.publishedAt?:"",saveNews.title?:"",saveNews.url?:"",saveNews.urlToImage?:"")
                            }
                        }

                    }
                }
            }else{

            }
        }
        is Resource.Error ->{
            Text(text = oneNews.message!!)
            println("Boş olan kısım")
        }else->{
            println("error")
        }
    }
}

@Composable
fun customFloatingButton(onSave : ()-> Unit){

    FloatingActionButton(onClick = onSave,
        backgroundColor = custemPink,
        contentColor = customWhite
    ) {
        Icon(Icons.Filled.Add,"Add Button")
    }
}




