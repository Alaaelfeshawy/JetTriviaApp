package com.example.jettriviaapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettriviaapp.data.DataOrException
import com.example.jettriviaapp.model.QuestionItem
import com.example.jettriviaapp.repository.QuestionRepository
import com.example.jettriviaapp.util.AppColors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor( private val repository: QuestionRepository)
    : ViewModel() {
    val data: MutableState<DataOrException<ArrayList<QuestionItem>,
            Boolean, Exception>> = mutableStateOf(
           DataOrException(null, true, Exception("")) )

    val questions : MutableList<QuestionItem>?
            get() = data.value.data?.toMutableList()

    val questionIndex = mutableStateOf(0)

    val question : QuestionItem ?
        get() = try {
        questions?.get(questionIndex.value)
    } catch (e : java.lang.Exception){
        null
    }

    val answerChoicesState : MutableList<String>?
           get() = question?.choices?.toMutableList()

    private val correctAnswerState =  mutableStateOf<Boolean?>(null)

    val selectedAnswerState = mutableStateOf<Pair<QuestionItem,Int>?>(null)

    private val answersList = ArrayList<Pair<QuestionItem,Int>?>()

    val progress :  MutableState<Float> = mutableStateOf(0.005f)

    init {
        answersList.clear()
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()
            if (data.value.data.toString().isNotEmpty()) {
                 data.value.loading = false
            }
        }

    }

    fun getTotalQuestionCount(): Int {
        return data.value.data?.toMutableList()?.size ?: 0
    }

    fun updateQuestionIndex() {
        questionIndex.value = questionIndex.value + 1
    }

    fun checkIsSelectedItem(questionIndex:Int) : Boolean{
       return selectedAnswerState.value?.first == questions?.get(questionIndex)
    }
    fun updateAnswer(questionItem: QuestionItem , answerIndex : Int , selectedAnswerState : MutableState<Pair<QuestionItem,Int>?>){
        selectedAnswerState.value = Pair(questionItem , answerIndex)
        answersList.add(selectedAnswerState.value)
        correctAnswerState.value = answerChoicesState?.get(answerIndex) == question?.answer
    }

    fun handleRadioButtonSelection(index:Int): Boolean {
       return (selectedAnswerState.value?.second == index && questions?.indexOf(selectedAnswerState.value?.first) == questionIndex.value )
    }

    fun getTextColor(index : Int) : Color{
        val isCurrentQuestionInAnswerList = answersList.find {
            it?.first == question
        }?.first
        return if (isCurrentQuestionInAnswerList != null && correctAnswerState.value==true && index == selectedAnswerState.value?.second)
            Color.Green else  if (isCurrentQuestionInAnswerList != null && correctAnswerState.value==false && index == selectedAnswerState.value?.second)
            Color.Red else AppColors.mOffWhite
    }

    fun getRadioButtonColor(index: Int) : Color{
        return if (correctAnswerState.value==true && index == selectedAnswerState.value?.second) Color.Green else Color.Red
    }

    fun getProgress(){
        progress.value = questionIndex.value * 0.005f
    }
}