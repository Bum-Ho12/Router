package com.example.router.presentation.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.router.presentation.viewmodels.LoginViewModel
import com.example.router.presentation.viewmodels.SharedAuthViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    sharedAuthViewModel: SharedAuthViewModel = koinViewModel(),
    onLogin: () -> Unit,
    onRegisterClick:() -> Unit,
    modifier: Modifier = Modifier,
){
    val localCounter by viewModel.counter.collectAsStateWithLifecycle()
    val sharedCounter by sharedAuthViewModel.counter.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = sharedAuthViewModel::bump
        ){
            Text("Shared counter: $sharedCounter")
        }

        Button(
            onClick = viewModel::bump
        ){
            Text("Local counter: $localCounter")
        }

        Button(
            onClick = onLogin
        ){
            Text("Login")
        }

        Button(
            onClick = onRegisterClick
        ){
            Text("Register")
        }
    }
}