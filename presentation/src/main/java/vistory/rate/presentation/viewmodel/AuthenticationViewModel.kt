package vistory.rate.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import vistory.rate.domain.repository.LoginRepository
import vistory.rate.domain.repository.LoginResult
import vistory.rate.domain.repository.RegisterResult
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<LoginResult?> = MutableStateFlow(null)
    val uiState: StateFlow<LoginResult?> = _uiState

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun updateEmail(input: String) {
        email = input
    }

    fun updatePassword(input: String) {
        password = input
    }


    fun login(email: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        loginRepository.login(email, password).collectLatest {
            _uiState.value = it
        }
    }
}