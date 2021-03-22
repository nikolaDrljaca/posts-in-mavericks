package com.example.postsinmavericks.ui.screens.posts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.postsinmavericks.network.NetworkModel


//rest are private to be used by the top one
@Composable
@ExperimentalMaterialApi
fun PostsScreen(
    posts: List<NetworkModel>,
    onPostClicked: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(posts) { post ->
            Surface(
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 12.dp),
                elevation = 1.dp,
                shape = RoundedCornerShape(8.dp)
            ) {
                ListItem(
                    modifier = Modifier.clickable { onPostClicked(post.id) },
                    text = { Text(text = post.title, maxLines = 1) },
                    secondaryText = {
                        Text(
                            text = post.body,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }
        }
    }
}

