package com.example.jettriviaapp.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.jettriviaapp.screens.QuestionsViewModel
import com.example.jettriviaapp.util.AppColors


@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val context = LocalContext.current
    if (viewModel.data.value.loading == true){
        Surface(modifier = Modifier.fillMaxSize(),
            color = AppColors.mDarkPurple
        ){
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                )
            }
        }
    }else{
        viewModel.questions?.let {
            viewModel.question?.let { questionItem ->
                QuestionDisplay(
                    viewModel = viewModel ,
                    questionItem = questionItem,
                ){
                    if (viewModel.checkIsSelectedItem(it)){
                        viewModel.updateQuestionIndex()
                    }else{
                        Toast.makeText(
                            context,
                            "Please select an answer",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}



