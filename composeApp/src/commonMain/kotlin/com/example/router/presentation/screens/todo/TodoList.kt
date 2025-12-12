package com.example.router.presentation.screens.todo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.router.presentation.viewmodels.TodoListViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TodoListScreen(
    viewModel: TodoListViewModel = koinViewModel(),
    onTodoCLick: (String) -> Unit,
    modifier: Modifier = Modifier
){
    val todos by viewModel.todos.collectAsStateWithLifecycle()
    LazyColumn(
        modifier = Modifier,
        contentPadding = PaddingValues(16.dp)
    ) {

        items(todos) { todo ->
            Text(
                todo,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable{
                        onTodoCLick(todo)
                    }
                    .padding(16.dp)
            )
        }
    }
}