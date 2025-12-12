package com.example.router


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.router.core.navigation.NavigationRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Scaffold { innerPadding ->
        NavigationRoot(
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}