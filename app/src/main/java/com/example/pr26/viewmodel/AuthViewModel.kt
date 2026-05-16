package com.example.pr26.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr26.data.model.User
import com.example.pr26.data.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val user: User? = null
)

class AuthViewModel(
    app: Application
) : AndroidViewModel(app) {

    private val repo = AuthRepository(app.applicationContext)

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun updateEmail(value: String) {
        _uiState.value = _uiState.value.copy(email = value, errorMessage = null)
    }

    fun updatePassword(value: String) {
        _uiState.value = _uiState.value.copy(password = value, errorMessage = null)
    }

    fun signOut() {
        _uiState.value = _uiState.value.copy(user = null)
    }

    fun signIn(onSuccess: () -> Unit) {
        val email = _uiState.value.email.trim()
        val password = _uiState.value.password

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

            val user = withContext(Dispatchers.IO) {
                repo.signIn(email, password)
            }

            if (user == null) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = "Неверный email или пароль"
                )
            } else {
                _uiState.value = _uiState.value.copy(isLoading = false, user = user)
                onSuccess()
            }
        }
    }

    // For UI tests or simple flows where Room isn't needed.
    fun debugSignIn(email: String, password: String, onSuccess: () -> Unit) {
        _uiState.value = _uiState.value.copy(email = email, password = password, user = User(email, password))
        onSuccess()
    }
}
