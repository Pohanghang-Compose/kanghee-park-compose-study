package com.example.pohanghang.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pohanghang.data.Screen
import com.example.pohanghang.ui.theme.MainDarkGreen
import com.example.pohanghang.ui.theme.MainGreen

@Composable
fun LoginScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GreetingTitle()
            IdTitle(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp)
            )
            IdTextField(
                modifier = Modifier.align(Alignment.Start)
            )
            PwTitle(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp)
            )
            PwTextField(
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.weight(1f))
            ButtonLogin(navController)
        }
    }
}

@Composable
fun GreetingTitle(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Pohanghang!",
        fontSize = 25.sp,
        modifier = modifier.padding(top = 70.dp, bottom = 30.dp)
    )
}

@Composable
fun IdTitle(modifier: Modifier = Modifier) {
    Text(
        text = "ID",
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun IdTextField(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier.background(color = Color.Transparent),
        placeholder = { Text("ID를 입력하세요") },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = MainDarkGreen,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        )
    )
}

@Composable
fun PwTitle(modifier: Modifier = Modifier) {
    Text(
        text = "Password",
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun PwTextField(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier.background(color = Color.Transparent),
        placeholder = { Text("Password를 입력하세요") },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = MainDarkGreen,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun ButtonLogin(navController: NavHostController) {
    Row {
        Button(
            enabled = true,
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = MainGreen,
                contentColor = Color.White,
                disabledContainerColor = Gray,
                disabledContentColor = Color.White,
            ),
            modifier = Modifier
                .padding(top = 20.dp, end = 15.dp, bottom = 50.dp)
                .width(150.dp)
        ) {
            Text(text = "로그인")
        }

        Button(
            enabled = true,
            onClick = {
                navController.navigate(Screen.SignUp.name)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MainGreen,
                contentColor = Color.White,
                disabledContainerColor = Gray,
                disabledContentColor = Color.White,
            ),
            modifier = Modifier
                .padding(top = 20.dp, start = 15.dp)
                .width(150.dp)
        ) {
            Text(text = "회원가입")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GreetingTitle()
            IdTitle(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp)
            )
            IdTextField(
                modifier = Modifier.align(Alignment.Start)
            )
            PwTitle(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp)
            )
            PwTextField(
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.weight(1f))
            ButtonLogin(navController)
        }
    }
}
