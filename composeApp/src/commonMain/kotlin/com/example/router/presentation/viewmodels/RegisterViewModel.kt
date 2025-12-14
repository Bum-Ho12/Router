package com.example.router.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.router.domain.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: AuthRepository
): ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    init {
        println("RegistrationViewModel: init")
    }

    fun bump(){
        viewModelScope.launch {
            val increment = repository.register(counter.value)
            _counter.update { increment }
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("RegistrationViewModel: cleared")
    }
}