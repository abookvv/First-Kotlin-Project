package vistory.rate.domain.repository

import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
    suspend fun register(email: String, password: String): Flow<RegisterResult>
}