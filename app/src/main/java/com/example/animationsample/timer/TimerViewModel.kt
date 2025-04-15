package com.example.animationsample.timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {

    private val _timerState = MutableStateFlow(TimerUiState.Idle as TimerUiState)
    val timerState: StateFlow<TimerUiState> = _timerState.asStateFlow()

    lateinit var timerJob: Job

    fun startTimer() {
        val currentState = _timerState.value
        if (currentState is TimerUiState.Running) return
        val currentTime = System.currentTimeMillis()
        while (true) {
            timerJob = viewModelScope.launch {
                _timerState.value = TimerUiState.Running(currentTime = currentTime)
                delay(1000)
            }
        }
    }

    fun pauseTimer() {
        val currentState = _timerState.value
        if (currentState !is TimerUiState.Running) return
        timerJob.cancel()
    }
}