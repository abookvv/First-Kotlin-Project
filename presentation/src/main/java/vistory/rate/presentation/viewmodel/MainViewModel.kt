package vistory.rate.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import vistory.rate.domain.repository.AuthRepository
import vistory.rate.domain.repository.RegisterResult
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {
    private val _authState = MutableStateFlow(false)
    val authState: StateFlow<Boolean> = _authState

    fun checkAuth() = viewModelScope.launch(Dispatchers.IO) {
        _authState.value = authRepository.isAuthenticated()
    }
    init {
        checkAuth()
    }
}