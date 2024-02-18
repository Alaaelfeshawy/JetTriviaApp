package com.example.jettriviaapp.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.jettriviaapp.util.AppColors

@Composable
fun Question(question : String = "Question") {
    Text(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.3f),
        text = question,
        style = TextStyle(color = AppColors.mOffWhite, fontSize = 20.sp)
    )
}
