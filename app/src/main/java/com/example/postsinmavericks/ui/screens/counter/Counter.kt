package com.example.postsinmavericks.ui.screens.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.postsinmavericks.ui.screens.counter.CounterViewModel.CounterState

@Composable
fun Counter() {
    val viewModel: CounterViewModel = mavericksViewModel()
    val state by viewModel.collectAsState()

    CounterScreen(
        state = state,
        onButtonClicked = { viewModel.incrementCount() }
    )
}

@Composable
private fun CounterScreen(
    state: CounterState,
    onButtonClicked: () -> Unit,
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { onButtonClicked() }) {
            Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
        }
    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Current count: ${state.count}")
            if (state.isEven) {
                Text(text = "The count is even.")
            }
        }
    }
}