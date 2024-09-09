package vistory.rate.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import vistory.rate.presentation.R
import vistory.rate.presentation.viewmodel.AuthenticationViewModel
import vistory.rate.presentation.ui.theme.authBackgroundColor
import vistory.rate.presentation.ui.theme.milk
import vistory.rate.presentation.ui.theme.pink


@Composable
fun AuthScreen(navController: NavController, viewModel: AuthenticationViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = authBackgroundColor
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditTextAuth(modifier = Modifier.fillMaxWidth(0.6f),
                stringResource(R.string.email),
                KeyboardType.Email,
                viewModel.email,
                onTextChanged = { viewModel.updateEmail(it) })

            Spacer(modifier = Modifier.height(8.dp))

            EditTextAuth(modifier = Modifier.fillMaxWidth(0.6f),
                stringResource(R.string.password),
                KeyboardType.Password,
                viewModel.password,
                onTextChanged = { viewModel.updatePassword(it) })

            Spacer(modifier = Modifier.height(32.dp))

            AuthButton(text = stringResource(R.string.login), onClick = {
                viewModel.login(viewModel.email, viewModel.password)
            })

            Spacer(modifier = Modifier.height(16.dp))

            AuthButton(text = stringResource(R.string.register), onClick = {
                navController.navigate("Registration")
            })

            Spacer(modifier = Modifier.imePadding())
        }
    }

}

@Composable
fun EditTextAuth(
    modifier: Modifier = Modifier,
    hint: String,
    keyboardType: KeyboardType,
    text: String,
    onTextChanged: (String) -> Unit
) {

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        value = text,
        onValueChange = onTextChanged,
        label = { Text(hint) },
        modifier = modifier,
        shape = RoundedCornerShape(8.dp), colors = TextFieldDefaults.colors(
            disabledContainerColor = milk,
            focusedContainerColor = milk
        )
    )
}

@Composable
fun AuthButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(0.6f),
        colors = ButtonDefaults.buttonColors(containerColor = pink),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text)
    }
}