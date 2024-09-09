package vistory.rate.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import vistory.rate.presentation.R
import vistory.rate.presentation.ui.theme.authBackgroundColor
import vistory.rate.presentation.ui.theme.darkText
import vistory.rate.presentation.ui.theme.white

@Composable
fun MainScreen(navController: NavController) {

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

    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = white
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()).padding(start = 8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            SettingsIcon()
            TitleText(text = stringResource(id = R.string.result))
        }
    }

}

@Composable
fun SettingsIcon() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp, top = 8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Image(
            painter = painterResource(id = R.drawable.settings_icon),
            contentDescription = stringResource(id = R.string.settings),
            modifier = Modifier.size(32.dp)
        )
    }
}


@Composable
fun TitleText(text: String) {
    Text(
        color = darkText, text = text, fontSize = 32.sp
    )
}