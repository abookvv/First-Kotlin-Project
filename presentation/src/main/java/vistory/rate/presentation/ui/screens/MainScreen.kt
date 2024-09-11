package vistory.rate.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import vistory.rate.presentation.ui.theme.grey
import vistory.rate.presentation.ui.theme.pink
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
        modifier = Modifier.fillMaxSize(), containerColor = white, bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                MainButton(
                    text = stringResource(id = R.string.start),
                    onClick = { navController.navigate("result") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            SettingsIcon()
            TitleText(text = stringResource(id = R.string.measure))
        }
        HeartImage()
    }

}

@Composable
fun MainButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
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
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun HeartImage() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .offset(x = (100).dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.heart_illustrations),
            contentDescription = stringResource(id = R.string.heart),
            modifier = Modifier.size(320.dp)
        )
    }
}


@Composable
fun TitleText(text: String) {
    Text(
        color = darkText, text = text, fontSize = 32.sp, modifier = Modifier.padding(start = 5.dp)
    )
}