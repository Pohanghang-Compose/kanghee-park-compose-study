package com.example.pohanghang.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pohanghang.data.Screen
import com.example.pohanghang.ui.theme.PohanghangTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PohanghangTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Login.name) {
                    composable(Screen.Login.name) {
                        LoginScreen(navController)
                    }
                    composable(Screen.SignUp.name) {
                        SignUpScreen(navController)
                    }
                }
            }
        }
    }
}
