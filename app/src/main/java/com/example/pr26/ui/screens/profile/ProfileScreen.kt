package com.example.pr26.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pr26.ui.components.AppTextField
import com.example.pr26.ui.components.BottomBar
import com.example.pr26.ui.theme.Background
import com.example.pr26.ui.theme.TextPrimary
import com.example.pr26.viewmodel.AuthViewModel
import com.example.pr26.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel(),
    profileViewModel: ProfileViewModel = viewModel()
) {
    val authState by authViewModel.uiState.collectAsState()
    val profileState by profileViewModel.uiState.collectAsState()

    LaunchedEffect(authState.user) {
        val u = authState.user ?: return@LaunchedEffect
        profileViewModel.setUser(u.email, u.password)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Профиль",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(20.dp))

            AppTextField(
                value = profileState.email,
                onValueChange = { profileViewModel.setUser(it, profileState.password) },
                label = "Email"
            )

            Spacer(modifier = Modifier.height(14.dp))

            AppTextField(
                value = profileState.password,
                onValueChange = { profileViewModel.setUser(profileState.email, it) },
                label = "Пароль"
            )
        }

        BottomBar(navController = navController)
    }
}

