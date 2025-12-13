package com.example.router.core.di.annotation

import com.example.router.data.TodoRepositoryImpl
import com.example.router.domain.TodoRepository
import com.example.router.presentation.viewmodels.TodoListViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class TodoModule {
    @Factory(binds = [TodoRepository::class])
    fun todoRepository() = TodoRepositoryImpl()

    @KoinViewModel
    fun todoViewModel(todoRepository: TodoRepository) = TodoListViewModel(todoRepository())
}