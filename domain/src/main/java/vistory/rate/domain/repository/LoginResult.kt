package vistory.rate.domain.repository

import vistory.rate.domain.model.User

sealed class LoginResult {
    data object Loading:LoginResult()
    data class Success(val user: User):LoginResult()
    data class Error(val error: Throwable?): LoginResult()
}