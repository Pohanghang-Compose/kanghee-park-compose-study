package com.example.pohanghang.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pohanghang.ui.theme.MainDarkGreen
import com.example.pohanghang.ui.theme.MainGreen

@Composable
fun SignUpScreen(navController: NavHostController, viewModel: SignUpViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignUpTitle()
            IdTitle(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp, start = 40.dp)
            )
            IdTextField(
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(start = 40.dp, end = 40.dp), viewModel

            )
            PwTitle(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp, start = 40.dp)
            )
            PwTextField(
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(start = 40.dp, end = 40.dp), viewModel
            )
            NickNameTitle(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp, start = 40.dp)
            )
            NickNameTextField(
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .padding(start = 40.dp, end = 40.dp), viewModel
            )
            Spacer(modifier = Modifier.weight(1f))
            ButtonSignUp(navController, viewModel)
        }
    }
}

@Composable
private fun SignUpTitle(modifier: Modifier = Modifier) {
    Text(
        text = "SIGN UP",
        fontWeight = Bold,
        fontSize = 25.sp,
        modifier = modifier.padding(top = 70.dp, bottom = 30.dp)
    )
}

@Composable
private fun IdTitle(modifier: Modifier = Modifier) {
    Text(
        text = "ID",
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
private fun IdTextField(modifier: Modifier = Modifier, viewModel: SignUpViewModel) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { id ->
            text = id
            viewModel.updateId(id.text)
        },
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
private fun PwTitle(modifier: Modifier = Modifier) {
    Text(
        text = "Password",
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
private fun PwTextField(modifier: Modifier = Modifier, viewModel: SignUpViewModel) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { pw ->
            text = pw
            viewModel.updatePw(pw.text)
        },
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
private fun NickNameTitle(modifier: Modifier = Modifier) {
    Text(
        text = "NickName",
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
private fun NickNameTextField(modifier: Modifier = Modifier, viewModel: SignUpViewModel) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { nickname ->
            text = nickname
            viewModel.updateNickname(nickname.text)
        },
        modifier = modifier.background(color = Color.Transparent),
        placeholder = { Text("Nickname을 입력하세요") },
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
private fun ButtonSignUp(navController: NavHostController, viewModel: SignUpViewModel) {
    Button(
        enabled = viewModel.isSignUp.value,
        onClick = {
            navController.popBackStack()
            viewModel.removeValue()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MainGreen,
            contentColor = Color.White,
            disabledContainerColor = Gray,
            disabledContentColor = Color.White,
        ),
        modifier = Modifier
            .padding(top = 20.dp, bottom = 50.dp, end = 30.dp, start = 30.dp)
            .width(3000.dp)
    ) {
        Text(text = "회원가입하기")
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {

}
