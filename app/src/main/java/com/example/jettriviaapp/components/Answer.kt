package com.example.jettriviaapp.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettriviaapp.model.QuestionItem
import com.example.jettriviaapp.screens.QuestionsViewModel
import com.example.jettriviaapp.util.AppColors


//@Preview
@Composable
fun Answer(
    viewModel: QuestionsViewModel,
    answerText : String = "answerText",
    index : Int,
    onSelectedAnswer : ()->Unit={})
{
    Row(modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth()
        .height(54.dp)
        .border(
            width = 4.dp,
            brush = Brush.linearGradient(
                listOf(
                    AppColors.mOffDarkPurple,
                    AppColors.mOffDarkPurple
                )
            ),
            shape = RoundedCornerShape(15.dp)
        )
        .clip(
            RoundedCornerShape(
                topStartPercent = 50,
                topEndPercent = 50,
                bottomEndPercent = 50,
                bottomStartPercent = 50,
            )
        ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = viewModel.handleRadioButtonSelection(index),
            onClick = {
                onSelectedAnswer.invoke()
            },
            modifier = Modifier.padding(start = 16.dp),
            colors = RadioButtonDefaults.colors(
                selectedColor = viewModel.getRadioButtonColor(index)
            )
        )

        val annotatedString = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    color = viewModel.getTextColor(index) ,
                    fontSize =  17.sp
                )
            ){
                append(answerText)
            }
        }
        Text(text = annotatedString)
    }
}