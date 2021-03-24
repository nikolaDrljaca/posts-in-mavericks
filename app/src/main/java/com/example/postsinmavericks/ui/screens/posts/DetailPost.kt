package com.example.postsinmavericks.ui.screens.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksActivityViewModel
import com.example.postsinmavericks.network.NetworkModel

@Composable
fun DetailPost(
    postId: Int
) {
    val postsViewModel: PostsViewModel = mavericksActivityViewModel()
    val state by postsViewModel.collectAsState { it.post }

    postsViewModel.updateId(id = postId)

    state?.let { post ->
        DetailPost(post = post)
    }
}

@Composable
private fun DetailPost(
    post: NetworkModel
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Author: ${post.id} || ${post.userId}")
            Text(text = post.title, maxLines = 2)
            Text(
                text = post.body,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}