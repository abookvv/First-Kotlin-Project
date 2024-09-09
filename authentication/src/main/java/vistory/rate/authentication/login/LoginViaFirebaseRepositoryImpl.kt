package vistory.rate.authentication.login

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import vistory.rate.domain.model.User
import vistory.rate.domain.repository.LoginResult
import vistory.rate.domain.repository.LoginRepository
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LoginViaFirebaseRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) : LoginRepository {
    override suspend fun login(email: String, password: String): Flow<LoginResult> = flow {
        emit(LoginResult.Loading)

        val result = suspendCoroutine { continuation ->
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    continuation.resume(LoginResult.Success(User(email)))
                } else {
                    continuation.resume(LoginResult.Error(task.exception?.fillInStackTrace()))
                }
            }
        }
        emit(result)
    }.flowOn(Dispatchers.IO)
}