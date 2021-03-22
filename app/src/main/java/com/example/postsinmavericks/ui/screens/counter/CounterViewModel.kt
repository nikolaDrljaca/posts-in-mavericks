package com.example.postsinmavericks.ui.screens.counter

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.PersistState
import com.example.postsinmavericks.ui.screens.counter.CounterViewModel.*

class CounterViewModel(initialState: CounterState):
    MavericksViewModel<CounterState>(initialState) {

    fun incrementCount() = setState { copy(count = count + 1) }

    data class CounterState(
        @PersistState val count: Int = 0
    ): MavericksState {
        val isEven = count % 2 == 0
    }
}