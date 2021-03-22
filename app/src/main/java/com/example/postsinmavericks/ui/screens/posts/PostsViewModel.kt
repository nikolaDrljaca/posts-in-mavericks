package com.example.postsinmavericks.ui.screens.posts

import com.airbnb.mvrx.*
import com.example.postsinmavericks.network.NetworkModel
import com.example.postsinmavericks.repository.PostsRepository
import com.example.postsinmavericks.ui.screens.posts.PostsViewModel.PostsState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PostsViewModel(initialState: PostsState) :
    MavericksViewModel<PostsState>(initialState) {
    private val repository = PostsRepository()

    init {
        getPosts()
    }

    fun updateId(id: Int) = setState { copy(postId = id) }

    //this is me editing some code

    private fun getPosts() =
        repository.postsFlow.execute { copy(posts = it) }

    data class PostsState(
        val posts: Async<List<NetworkModel>> = Uninitialized,
        val postId: Int? = null
    ) : MavericksState {

        val post = getPost(postId)
        private fun getPost(id: Int?): NetworkModel? = posts()?.firstOrNull { it.id == id }
    }
}