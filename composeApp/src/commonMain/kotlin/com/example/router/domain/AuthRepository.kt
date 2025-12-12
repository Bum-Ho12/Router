package com.example.router.domain

interface AuthRepository {
    suspend fun register(): Int
    suspend fun login(): Int
    suspend fun sharedAuth(): Int
}