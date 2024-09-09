package vistory.rate.authentication.registration

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import vistory.rate.domain.model.User
import vistory.rate.domain.repository.LoginResult
import vistory.rate.domain.repository.LoginRepository
import vistory.rate.domain.repository.RegisterRepository
import vistory.rate.domain.repository.RegisterResult
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RegisterViaFirebaseRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) : RegisterRepository {
    override suspend fun register(email: String, password: String): Flow<RegisterResult> = flow {
        emit(RegisterResult.Loading)

        val result = suspendCoroutine { continuation ->
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    continuation.resume(RegisterResult.Success)
                } else {
                    continuation.resume(RegisterResult.Error(task.exception?.fillInStackTrace()))
                }
            }
        }
        emit(result)
    }.flowOn(Dispatchers.IO)
}