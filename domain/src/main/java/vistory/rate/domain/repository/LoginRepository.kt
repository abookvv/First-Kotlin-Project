package vistory.rate.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(email: String, password: String): Flow<LoginResult>
}