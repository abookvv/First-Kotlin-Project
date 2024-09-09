package vistory.rate.authentication

import com.google.firebase.auth.FirebaseAuth
import vistory.rate.domain.repository.AuthRepository
import javax.inject.Inject

class IsAuthenticatedRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) :
    AuthRepository {
    override fun isAuthenticated(): Boolean {
        val currentUser = auth.currentUser
        return currentUser != null
    }
}