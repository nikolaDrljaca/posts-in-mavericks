package com.example.postsinmavericks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.mvrx.Mavericks
import com.example.postsinmavericks.ui.screens.counter.Counter
import com.example.postsinmavericks.ui.screens.posts.Posts
import com.example.postsinmavericks.ui.theme.PostsInMavericksTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mavericks.initialize(this)
        setContent {
            PostsInMavericksTheme {
                Counter()
                //Posts()
                //AppNavigator()
            }
        }
    }
}