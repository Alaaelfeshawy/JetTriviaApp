package com.example.jettriviaapp.components

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.example.jettriviaapp.util.AppColors

@Composable
fun Button(
    modifier: Modifier,
    onNextClick: (Int) -> Unit,
    questionIndex: MutableState<Int>,
) {
    androidx.compose.material3.Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.mLightBlue
        ),
        onClick = {
            onNextClick.invoke(questionIndex.value)
        }) {
        Text(text = "Next")
    }
}

