package com.example.newsappcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "HOME",
        title = "HOME",
        icon = Icons.Default.Home
    )

    object SEARCH : BottomBarScreen(
        route = "SEARCH",
        title = "SEARCH",
        icon = Icons.Default.Search
    )

    object SAVE : BottomBarScreen(
        route = "SAVE",
        title = "SAVE",
        icon = Icons.Default.Save
    )
}