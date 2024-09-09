package vistory.rate.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import vistory.rate.domain.repository.LoginResult
import vistory.rate.domain.repository.RegisterResult
import vistory.rate.presentation.viewmodel.AuthenticationViewModel
import vistory.rate.presentation.ui.screens.AuthScreen
import vistory.rate.presentation.ui.screens.BottomNavBar
import vistory.rate.presentation.ui.screens.RegistrationScreen
import vistory.rate.presentation.viewmodel.MainViewModel
import vistory.rate.presentation.viewmodel.RegistrationViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private val authViewModel: AuthenticationViewModel by viewModels()

    private val registrationViewModel: RegistrationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            vistory.rate.presentation.ui.theme.VistoryRateTheme {
                initMain()
            }
        }
    }

    @Composable
    fun initMain() {
        val uiState by authViewModel.uiState.collectAsState()

        LaunchedEffect(uiState) {
            if(uiState is LoginResult.Success){
                mainViewModel.checkAuth()
            }
        }

        val mainNavController = rememberNavController()
        if (mainViewModel.authState.collectAsState().value) {
            BottomNavBar(mainNavController)
        } else {
            MyApp(mainNavController)
        }
    }

    @Composable
    fun MyApp(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "Auth") {
            composable("Auth") { AuthScreen(navController, authViewModel) }
            composable("Registration") { RegistrationScreen(navController, registrationViewModel) }
        }
    }
}


