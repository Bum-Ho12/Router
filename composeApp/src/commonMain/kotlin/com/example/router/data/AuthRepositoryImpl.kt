package com.example.router.data

import com.example.router.domain.AuthRepository

class AuthRepositoryImpl(): AuthRepository {
    override suspend fun login(counter: Int): Int {
        val increment = counter + 1
        return increment
    }

    override suspend fun register(counter: Int): Int {
        val increment = counter + 1
        return increment
    }

    override suspend fun sharedAuth(counter: Int): Int {
        val increment = counter + 1
        return increment
    }
}