package vistory.rate.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor() : ViewModel() {
    var sys by mutableStateOf("")
        private set

    fun updateSys(input: String) {
        sys = input
    }

    var dia by mutableStateOf("")
        private set

    fun updateDia(input: String) {
        dia = input
    }
}