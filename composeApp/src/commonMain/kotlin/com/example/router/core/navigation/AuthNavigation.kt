package com.example.router.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.router.core.navigation.Route
import com.example.router.presentation.screens.auth.LoginScreen
import com.example.router.presentation.viewmodels.LoginViewModel
import com.example.router.presentation.viewmodels.RegisterViewModel
import com.example.router.presentation.viewmodels.SharedAuthViewModel
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun AuthNavigation(
    onLogin: () -> Unit,
    modifier: Modifier = Modifier
){
    val authBackStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class){
                    subclass(Route.Auth.Login::class, Route.Auth.Login.serializer())
                    subclass(Route.Auth.Register::class, Route.Auth.Register.serializer())
                }
            }
        },
        Route.Auth.Login
    )

    val sharedAuthViewModel = viewModel { SharedAuthViewModel() }
    NavDisplay(
        backStack = authBackStack,
        modifier = modifier,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Route.Auth.Login>{
                LoginScreen(
                    viewModel = viewModel { LoginViewModel() },
                    sharedAuthViewModel = sharedAuthViewModel,
                    onLogin = onLogin,
                    onRegisterClick = {
                        authBackStack.add(Route.Auth.Register)
                    }
                )
            }

            entry<Route.Auth.Register>{
                LoginScreen(
                    viewModel = viewModel { RegisterViewModel() },
                    sharedAuthViewModel = sharedAuthViewModel,
                )
            }
        }
    )
}