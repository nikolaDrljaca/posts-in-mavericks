package com.example.postsinmavericks.repository

import com.example.postsinmavericks.network.PostsApi
import kotlinx.coroutines.flow.flow

class PostsRepository {
    private val api = PostsApi.retrofitService

    val postsFlow = flow { emit(api.getPosts()) }
}