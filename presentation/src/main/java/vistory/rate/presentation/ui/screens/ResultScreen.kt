package vistory.rate.presentation.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import vistory.rate.presentation.R
import vistory.rate.presentation.ui.theme.darkText
import vistory.rate.presentation.ui.theme.grey
import vistory.rate.presentation.ui.theme.greyTextField
import vistory.rate.presentation.ui.theme.pink
import vistory.rate.presentation.ui.theme.white
import vistory.rate.presentation.ui.theme.whiteBackground
import vistory.rate.presentation.viewmodel.ResultViewModel


@Composable
fun ResultScreen(navController: NavController) {

//    val uiState by viewModel.uiState.collectAsState()
//
//    LaunchedEffect(uiState) {
//        when(uiState){
//            is LoginResult.Success -> ""
//            is LoginResult.Loading -> ""
//            null -> ""
//            is LoginResult.Error -> ""
//        }
//    }
    val viewModel = viewModel<ResultViewModel>()

    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = white, bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ResearchButton(
                    text = stringResource(id = R.string.continue_research),
                    onClick = { /* Handle click */ }
                )
                SaveResultButton(
                    text = stringResource(id = R.string.save_result),
                    onClick = { /* Handle click */ }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {
            SettingsIcon()
            TitleText(text = stringResource(id = R.string.measure))
            Spacer(modifier = Modifier.height(32.dp))
            MiniTitleText(text = stringResource(id = R.string.arterial_pressure))
            Spacer(modifier = Modifier.height(8.dp))
            ArterialPressureViews(
                onTextChangedSYS = { viewModel.updateSys(it) },
                onTextChangedDIA = {
                    viewModel.updateDia(it)
                }, textSys = viewModel.sys, textDia = viewModel.dia
            )
        }
    }
}

@Composable
fun ArterialPressureViews(
    onTextChangedSYS: (String) -> Unit,
    onTextChangedDIA: (String) -> Unit,
    textSys: String,
    textDia: String
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
            .background(grey)
            .padding(start = 5.dp, end = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(01f)
                .padding(end = 5.dp)
        ) {
            PressureEditText(textSys, onTextChanged = onTextChangedSYS)
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(start = 5.dp)
        ) {
            PressureEditText(textDia, onTextChanged = onTextChangedDIA)
        }
    }
}

@Composable
fun PressureEditText(text: String, onTextChanged: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Background color for the Box
    ) {
        TextField(
            value = text,
            onValueChange = onTextChanged,
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            shape = RectangleShape
        )
        // Bottom border using Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp) // Height of the border
                .background(greyTextField) // Border color
                .align(Alignment.BottomCenter) // Align the border at the bottom
        )
    }
}

@Composable
fun SaveResultButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(0.85f)
            .padding(bottom = 20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = pink),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text, modifier.padding(vertical = 8.dp))
    }
}

@Composable
fun ResearchButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(0.85f)
            .padding(bottom = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = white,
            contentColor = whiteBackground
        ),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, whiteBackground)
    ) {
        Text(text, modifier.padding(vertical = 8.dp))
    }
}

@Composable
fun MiniTitleText(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        Alignment.Center
    ) {
        Text(
            color = darkText, text = text, fontSize = 20.sp
        )
    }

}

