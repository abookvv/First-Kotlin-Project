package vistory.rate.domain.repository

interface AuthRepository {
    fun isAuthenticated(): Boolean
}