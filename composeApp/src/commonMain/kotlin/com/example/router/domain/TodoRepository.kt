package com.example.router.domain

interface TodoRepository {
    suspend fun getTodos(): List<String>
}