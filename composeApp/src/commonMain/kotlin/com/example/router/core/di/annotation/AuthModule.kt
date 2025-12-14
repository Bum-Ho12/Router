package com.example.router.core.di.annotation

import com.example.router.data.AuthRepositoryImpl
import com.example.router.domain.AuthRepository
import com.example.router.presentation.viewmodels.LoginViewModel
import com.example.router.presentation.viewmodels.RegisterViewModel
import com.example.router.presentation.viewmodels.SharedAuthViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class AuthModule {
    @Factory(binds = [AuthRepository::class ])
    fun authRepository() = AuthRepositoryImpl()

    @KoinViewModel
    fun loginViewModel(authRepository: AuthRepository) = LoginViewModel(repository = authRepository())

    @KoinViewModel
    fun registerViewModel(authRepository: AuthRepository) = RegisterViewModel(repository = authRepository())

    @KoinViewModel
    fun sharedAuthViewModel(authRepository: AuthRepository) = SharedAuthViewModel(repository = authRepository())
}
