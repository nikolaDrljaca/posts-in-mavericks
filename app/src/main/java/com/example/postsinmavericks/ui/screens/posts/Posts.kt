package com.example.postsinmavericks.ui.screens.posts

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.*
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksActivityViewModel
import com.example.postsinmavericks.network.NetworkModel

import kotlinx.coroutines.flow.onEach

@ExperimentalMaterialApi
@Composable
fun Posts(
    onPostClicked: (Int) -> Unit,
) {
    val postsViewModel: PostsViewModel = mavericksActivityViewModel()
    val posts by postsViewModel.collectAsState { it.posts }
    when (posts) {
        is Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is Success -> {
            PostsScreen(
                posts = posts()!!,
                onPostClicked = { onPostClicked(it) }
            )
        }
        is Fail -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                val error = (posts as Fail<List<NetworkModel>>).error
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Something went wrong: $error",
                    color = Color.Red
                )
            }
        }
        is Uninitialized -> {
        }
    }
}