package com.example.newsappcompose.view


import android.graphics.drawable.Icon
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsappcompose.model.Article
import com.example.newsappcompose.model.NewsModel
import com.example.newsappcompose.model.Source
import com.example.newsappcompose.ui.theme.custemPink
import com.example.newsappcompose.ui.theme.customWhite
import com.example.newsappcompose.util.Resource
import com.example.newsappcompose.viewmodel.OneNewsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response

@Composable
fun detailView(content: String,
    viewModel : OneNewsViewModel = hiltViewModel()
               ){

    val oneNews = produceState<Resource<NewsModel>>(initialValue = Resource.Loading()){
        value = viewModel.getOneNews(content)
    }.value


    when(oneNews){
        is Resource.Success ->{
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
                    customFloatingButton {}
                }

            }
        }
        is Resource.Error ->{
            Text(text = oneNews.message!!)
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




