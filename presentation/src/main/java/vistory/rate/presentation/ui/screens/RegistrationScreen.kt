package vistory.rate.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import vistory.rate.domain.repository.RegisterResult
import vistory.rate.presentation.R
import vistory.rate.presentation.ui.theme.authBackgroundColor
import vistory.rate.presentation.ui.theme.milk
import vistory.rate.presentation.viewmodel.RegistrationViewModel

@Composable
fun RegistrationScreen(navController: NavController, viewModel: RegistrationViewModel) {
    val screenHeightDp = LocalConfiguration.current.screenHeightDp.dp
    val topOffset = screenHeightDp * 0.2f

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        when(uiState){
            is RegisterResult.Success -> navController.popBackStack()
            is RegisterResult.Loading -> ""
            null -> ""
            is RegisterResult.Error -> ""
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = authBackgroundColor
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .offset(y = topOffset),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EditTextAuth(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    hint = stringResource(R.string.email),
                    keyboardType = KeyboardType.Email,
                    text = viewModel.email,
                    onTextChanged = { viewModel.updateEmail(it) }
                )

                Spacer(modifier = Modifier.height(8.dp))

                EditTextAuth(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    hint = stringResource(R.string.password),
                    keyboardType = KeyboardType.Password,
                    text = viewModel.password,
                    onTextChanged = { viewModel.updatePassword(it) }
                )
            }

            AuthButton(
                text = stringResource(R.string.to_register),
                onClick = {
                    viewModel.register(viewModel.email, viewModel.password)
                },
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .align(Alignment.Center)
            )
        }
    }
}