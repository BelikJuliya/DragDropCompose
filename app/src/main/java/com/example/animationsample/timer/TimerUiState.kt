package com.example.animationsample.timer

sealed class TimerUiState {
    object Idle: TimerUiState()
    data class Running(
        val currentTime: Long
    ): TimerUiState()
    data class Paused(
        val pausedAt: Long
    ): TimerUiState()
}