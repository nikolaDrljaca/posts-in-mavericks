package com.example.postsinmavericks

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.postsinmavericks.ui.screens.posts.DetailPost
import com.example.postsinmavericks.ui.screens.posts.Posts

@ExperimentalMaterialApi
@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            Posts {
                navController.navigate("detail/$it")
            }
        }

        composable(
            route = "detail/{postId}",
            arguments = listOf(navArgument("postId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("postId")
            id?.let {
                DetailPost(postId = it)
            }
        }
    }

}