package com.example.jettriviaapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jettriviaapp.model.QuestionItem
import com.example.jettriviaapp.screens.QuestionsViewModel
import com.example.jettriviaapp.util.AppColors

@Composable
fun QuestionDisplay(
    viewModel: QuestionsViewModel,
    questionItem: QuestionItem,
    onNextClick:(Int)->Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = AppColors.mDarkPurple
    ) {
        Column(modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            LaunchedEffect(key1 = viewModel.questionIndex.value){
                viewModel.getProgress()
            }
            Progress(viewModel.progress.value)
            QuestionTracker(currentQuestionNumber= viewModel.questionIndex.value.plus(1),
                totalQuestionsNumber= viewModel.getTotalQuestionCount())
            DottedLine()
            Question(questionItem.question)
            viewModel.answerChoicesState?.forEachIndexed { index, answerText ->
                Answer(viewModel ,answerText , index){
                    viewModel.updateAnswer(questionItem,index,viewModel.selectedAnswerState)
                }
            }
            Button(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(12.dp), onNextClick, viewModel.questionIndex)
        }
    }
}
