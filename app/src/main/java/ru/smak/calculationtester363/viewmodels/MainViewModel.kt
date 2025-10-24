package ru.smak.calculationtester363.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import ru.smak.calculationtester363.models.CardModel

class MainViewModel : ViewModel() {

    val card = CardModel()
    var cardColor by mutableStateOf(Color.Unspecified)
    ///val x = mutableStateListOf<>()

    private var _userValue by mutableStateOf("")
    var userValue: String
        get() = _userValue
        set(value) {
            if (
                value.isEmpty()
                || value == "-"
                || (value.toIntOrNull() != null &&
                    value.toIntOrNull() in -100..100
                )
            ) _userValue = value
        }

    fun checkResult(){
        if (card.isCorrect(userValue.toIntOrNull())){
            cardColor = Color.Green
        } else {
            cardColor = Color.Red
        }
    }
}