package vistory.rate.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import vistory.rate.authentication.login.LoginViaFirebaseRepositoryImpl
import vistory.rate.authentication.registration.RegisterViaFirebaseRepositoryImpl
import vistory.rate.domain.repository.LoginRepository
import vistory.rate.domain.repository.RegisterRepository

@Module
@InstallIn(ViewModelComponent::class)
object AuthModule {

    @ViewModelScoped
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth

    @ViewModelScoped
    @Provides
    fun provideLoginRepository(auth: FirebaseAuth): LoginRepository {
        return LoginViaFirebaseRepositoryImpl(auth)
    }

    @ViewModelScoped
    @Provides
    fun provideRegisterRepository(auth: FirebaseAuth): RegisterRepository {
        return RegisterViaFirebaseRepositoryImpl(auth)
    }
}