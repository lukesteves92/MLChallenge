package com.inspirecoding.mlchallenge.main.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.inspirecoding.mlchallenge.navigation.nav.Navigation
import com.inspirecoding.mlchallenge.navigation.screen.Screen
import com.inspirecoding.mlchallenge.ui.theme.color.BackgroundColor
import com.inspirecoding.mlchallenge.ui.theme.main.MLChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MLChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundColor
                ) {
                    NavigateHome(navController = navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigateHome(navController: NavHostController) {
    Navigation(navController = navController, Screen.Home.route)
}