package vistory.rate.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import vistory.rate.presentation.R
import vistory.rate.presentation.ui.theme.darkerWhite
import vistory.rate.presentation.ui.theme.white

@Composable
fun BottomNavBar(navController: NavHostController) {
    val currentScreen by navController.currentBackStackEntryAsState()
    val currentRoute = currentScreen?.destination?.route

    Scaffold(
        bottomBar = {
            BottomAppBar(modifier = Modifier.background(brush = Brush.horizontalGradient(
                colors = listOf(white, darkerWhite)
            ))) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.menu_graph_icon),
                            contentDescription = "graph"
                        )
                    },
                    label = { Text("") },
                    selected = currentRoute == "graph",
                    onClick = { navController.navigate("graph") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.menu_main_icon),
                            contentDescription = "main"
                        )
                    },
                    label = { Text("") },
                    selected = currentRoute == "main",
                    onClick = { navController.navigate("main") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.menu_info_icon),
                            contentDescription = "info"
                        )
                    },
                    label = { Text("") },
                    selected = currentRoute == "info",
                    onClick = { navController.navigate("info") }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "main",
            Modifier.padding(innerPadding)
        ) {
            composable("graph") { GraphScreen() }
            composable("main") { MainScreen(navController) }
            composable("info") { InfoScreen() }
        }
    }
}