package com.example.animationsample.timer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TimerScreen(viewModel: TimerViewModel) {
    val timerState = viewModel.timerState.collectAsState()
    val stateValue = timerState.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (stateValue) {
            is TimerUiState.Idle -> {
                Button(onClick = {
                    viewModel.startTimer()
                }) {
                    Text(text = "Start timer")
                }
            }

            is TimerUiState.Paused -> {
                Box {
                    Text(text = "Current time = ${formatTime(stateValue.pausedAt)}")
                }
                Button(onClick = {
                    viewModel.startTimer()
                }) {
                    Text(text = "Start timer")
                }
            }

            is TimerUiState.Running -> {
                Box {
                    Text(text = "Current time = ${formatTime(stateValue.currentTime)}")
                }
            }
        }
    }
}

@Composable
fun UpdatableTimer(state: TimerUiState) {

}
fun formatTime(seconds: Long): String {
    val mins = seconds / 60
    val secs = seconds % 60
    return String.format("%02d:%02d", mins, secs)
}