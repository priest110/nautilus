package com.example.nautilus

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nautilus.data.DataSource
import com.example.nautilus.ui.HomeScreen
import com.example.nautilus.ui.InfoScreen
import com.example.nautilus.ui.ShowersViewModel

/**
 * enum values that represent the screens in the app
 */
enum class NautilusScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Info(title = R.string.info),
}

@Composable
fun NautilusApp(
    viewModel: ShowersViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {  ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = NautilusScreen.Home.name,
        ) {
            composable(route = NautilusScreen.Home.name) {
                HomeScreen(
                    onNextButtonClicked = {
                        navController.navigate(NautilusScreen.Info.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = NautilusScreen.Info.name) {
                InfoScreen(
                    total = uiState.totalLiters,
                    messages = DataSource.awarenessMessages,
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
    }
}