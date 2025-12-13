package com.example.router.data

import com.example.router.domain.AuthRepository

class AuthRepositoryImpl(): AuthRepository {
    override suspend fun login(): Int {
        TODO( "Not yet implemented" )
    }

    override suspend fun register(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun sharedAuth(): Int {
        TODO("Not yet implemented")
    }
}