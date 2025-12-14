package com.example.router.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.router.domain.AuthRepository
import com.example.router.domain.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthRepository
): ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    init {
        println("LoginViewModel: init")
    }

    fun bump(){
        viewModelScope.launch {
            val increment = repository.login(counter = counter.value)
            _counter.update { increment }
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("LoginViewModel: cleared")
    }
}