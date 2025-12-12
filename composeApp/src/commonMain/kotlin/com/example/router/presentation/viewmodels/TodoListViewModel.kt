package com.example.router.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.router.domain.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TodoListViewModel(
    private  val repository: TodoRepository
): ViewModel() {
    private val _todos = MutableStateFlow(
        emptyList<String>()
    )
    val todos = _todos.asStateFlow()

    init {
        viewModelScope.launch {
            val initTodos = repository.getTodos()
            _todos.update { initTodos }
        }
    }
}