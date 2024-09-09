package vistory.rate.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import vistory.rate.presentation.viewmodel.AuthenticationViewModel
import vistory.rate.presentation.ui.screens.AuthScreen
import vistory.rate.presentation.ui.screens.RegistrationScreen
import vistory.rate.presentation.viewmodel.RegistrationViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val authViewModel: AuthenticationViewModel by viewModels()

    private val registrationViewModel: RegistrationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            vistory.rate.presentation.ui.theme.VistoryRateTheme {
                MyApp()
            }
        }
    }

        @Composable
        fun MyApp() {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Auth") {
                composable("Auth") { AuthScreen(navController, authViewModel) }
                composable("Registration") { RegistrationScreen(navController, registrationViewModel) }
            }
        }
}


