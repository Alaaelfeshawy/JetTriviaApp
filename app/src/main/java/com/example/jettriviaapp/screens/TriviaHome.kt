package com.example.jettriviaapp.screens

import androidx.compose.runtime.Composable
import com.example.jettriviaapp.components.Questions

@Composable
fun TriviaHome(viewModel: QuestionsViewModel){
    Questions(viewModel)
}