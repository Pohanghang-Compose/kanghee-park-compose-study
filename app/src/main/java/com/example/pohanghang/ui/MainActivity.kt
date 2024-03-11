package com.example.pohanghang.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pohanghang.data.Screen
import com.example.pohanghang.ui.login.LoginScreen
import com.example.pohanghang.ui.main.MainScreen
import com.example.pohanghang.ui.signup.SignUpScreen
import com.example.pohanghang.ui.signup.SignUpViewModel
import com.example.pohanghang.ui.signup.SignUpViewModelFactory
import com.example.pohanghang.ui.theme.PohanghangTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val signUpViewModel = ViewModelProvider(
                this,
                SignUpViewModelFactory()
            )[SignUpViewModel::class.java]

            PohanghangTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Login.name) {
                    composable(Screen.Login.name) {
                        LoginScreen(navController = navController)
                    }
                    composable(Screen.SignUp.name) {
                        SignUpScreen(navController = navController, viewModel = signUpViewModel)
                    }
                    composable(Screen.Main.name){
                        MainScreen(navController = navController)
                    }
                }
            }
        }
    }
}
