package com.example.router.data

import com.example.router.domain.TodoRepository

class TodoRepositoryImpl(): TodoRepository {
    override suspend fun getTodos(): List<String> {
        return (1..100).map {
            "Todo $it"
        }
    }
}