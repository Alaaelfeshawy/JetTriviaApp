package com.example.jettriviaapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettriviaapp.util.AppColors

@Composable
fun QuestionTracker(currentQuestionNumber:Int = 0, totalQuestionsNumber : Int = 0) {

    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = AppColors.mLightGray,
                fontWeight = FontWeight.Bold,
                fontSize = 27.sp
            )){
            append("Question $currentQuestionNumber/")
            withStyle(style = SpanStyle(
                color = AppColors.mLightGray,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp
            )
            ){
                append("$totalQuestionsNumber")
            }
        }
    },
        modifier = Modifier.padding(12.dp)
    )
}

