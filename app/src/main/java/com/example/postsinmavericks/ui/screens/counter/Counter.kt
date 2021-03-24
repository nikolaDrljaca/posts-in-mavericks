package com.example.postsinmavericks.ui.screens.counter

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.postsinmavericks.ui.screens.counter.CounterViewModel.CounterState

@Composable
fun Counter() {
    val counterViewModel: CounterViewModel = mavericksViewModel()
    val state by counterViewModel.collectAsState()

    CounterScreen(
        state = state,
        onFabClicked = { counterViewModel.incrementCount() },
        onButtonClicked = { counterViewModel.resetCount() }
    )
}

@Composable
private fun CounterScreen(
    state: CounterState,
    onFabClicked: () -> Unit,
    onButtonClicked: () -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onFabClicked() }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Current count: ${state.count}")
            if (state.isEven) {
                Text(text = "The count is even.")
            }
            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = onButtonClicked) {
                Text(text = "Reset", style = MaterialTheme.typography.button)
            }
        }
    }
}