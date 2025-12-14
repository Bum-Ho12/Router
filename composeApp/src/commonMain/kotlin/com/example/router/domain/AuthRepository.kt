package com.example.router.domain

interface AuthRepository {
    suspend fun register(counter: Int): Int
    suspend fun login(counter: Int): Int
    suspend fun sharedAuth(counter: Int): Int
}