package com.example.pr26.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr26.navigation.Screen
import com.example.pr26.ui.theme.Primary
import com.example.pr26.utils.Validation

@Composable
fun SignInScreen(
    navController: NavController
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var emailError by remember {
        mutableStateOf<String?>(null)
    }

    var passwordError by remember {
        mutableStateOf<String?>(null)
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    val isFormValid =
        emailError == null &&
                passwordError == null &&
                email.isNotBlank() &&
                password.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 32.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(110.dp))

        Text(
            text = "Привет!",

            fontSize = 42.sp,

            fontWeight = FontWeight.Medium,

            color = Color(0xFF2F2F2F)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Заполните свои данные или\nПродолжите через социальные медиа",

            fontSize = 20.sp,

            lineHeight = 30.sp,

            textAlign = TextAlign.Center,

            color = Color(0xFF9AA0A6)
        )

        Spacer(modifier = Modifier.height(70.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Email",

                fontSize = 18.sp,

                color = Color(0xFF2F2F2F)
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = email,

                onValueChange = {

                    email = it

                    emailError =
                        Validation.validateEmail(it)
                },

                singleLine = true,

                placeholder = {

                    Text(
                        text = "xyz@gmail.com",

                        color = Color(0xFFB6B6B6)
                    )
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),

                shape = RoundedCornerShape(16.dp),

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF1F1F1),
                    unfocusedContainerColor = Color(0xFFF1F1F1),

                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            )

            if (emailError != null) {

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = emailError!!,

                    color = MaterialTheme.colorScheme.error,

                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Пароль",

                fontSize = 18.sp,

                color = Color(0xFF2F2F2F)
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = password,

                onValueChange = {

                    password = it

                    passwordError =
                        Validation.validatePassword(it)
                },

                singleLine = true,

                visualTransformation =
                    if (passwordVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },

                placeholder = {

                    Text(
                        text = "••••••••",

                        color = Color(0xFFB6B6B6)
                    )
                },

                trailingIcon = {

                    IconButton(
                        onClick = {
                            passwordVisible = !passwordVisible
                        }
                    ) {

                        Icon(
                            imageVector =
                                if (passwordVisible) {
                                    Icons.Outlined.Visibility
                                } else {
                                    Icons.Outlined.VisibilityOff
                                },

                            contentDescription = null,

                            tint = Color(0xFF9E9E9E)
                        )
                    }
                },

                shape = RoundedCornerShape(16.dp),

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF1F1F1),
                    unfocusedContainerColor = Color(0xFFF1F1F1),

                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            )

            if (passwordError != null) {

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = passwordError!!,

                    color = MaterialTheme.colorScheme.error,

                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),

            contentAlignment = Alignment.CenterEnd
        ) {

            Text(
                text = "Восстановить",

                color = Color(0xFF9AA0A6),

                fontSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(36.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(62.dp)
                .background(
                    color =
                        if (isFormValid) {
                            Primary
                        } else {
                            Primary.copy(alpha = 0.5f)
                        },

                    shape = RoundedCornerShape(18.dp)
                )
                .clickable(
                    enabled = isFormValid
                ) {

                    navController.navigate(Screen.Home.route) {

                        popUpTo(Screen.SignIn.route) {
                            inclusive = true
                        }
                    }
                },

            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "Войти",

                color = Color.White,

                fontSize = 20.sp,

                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.Center,

            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Вы впервые? ",

                color = Color(0xFF8E8E8E),

                fontSize = 18.sp
            )

            Text(
                text = "Создать пользователя",

                color = Color(0xFF2F2F2F),

                fontSize = 18.sp,

                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(36.dp))
    }
}