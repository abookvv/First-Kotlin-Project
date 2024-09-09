package vistory.rate.domain.repository

import vistory.rate.domain.model.User

sealed class RegisterResult {
    data object Loading:RegisterResult()
    data object Success:RegisterResult()
    data class Error(val error: Throwable?): RegisterResult()
}