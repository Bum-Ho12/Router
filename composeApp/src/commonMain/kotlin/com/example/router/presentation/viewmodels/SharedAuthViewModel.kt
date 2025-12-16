package com.example.router.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.router.domain.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SharedAuthViewModel(
    private val repository: AuthRepository
): ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val sequentialScope = CoroutineScope(
        viewModelScope.coroutineContext +
                Dispatchers.Default.limitedParallelism(1)
    )

    init {
        println("SharedAuthViewModel: init")
    }

    fun bump() {
        sequentialScope.launch {
            _isLoading.value = true
            try {
                val newValue = repository.register(_counter.value)
                _counter.value = newValue
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("SharedAuthViewModel: cleared")
    }
}