package com.goals.goalapp.login.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goals.goalapp.data.local.PreferencesHelper
import com.goals.goalapp.domain.Repository
import com.goals.goalapp.login.domain.UserRepository
import com.goals.goalapp.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userRepository: UserRepository,
    private val repository: Repository,
    private val preferencesHelper: PreferencesHelper,
) : ViewModel() {

    private var _loginStateResponse = MutableStateFlow(false)
    val loginStateResponse: StateFlow<Boolean> get() = _loginStateResponse

    init {
        val logPass = preferencesHelper.getLogAndPass()
        _loginStateResponse.value = logPass != null
    }

    fun login(context: Context, login: String, pass: String) {
        viewModelScope.launch {
            repository.getInfo(context, login, pass).collect { state ->
                when (state) {
                    is UiState.Error -> {
                        // showtoast
                    }

                    UiState.Loading -> {
                    }

                    is UiState.Success -> {
                        preferencesHelper.putLogAndPass(login, pass)
                        _loginStateResponse.value = true
                    }
                }
            }

        }
    }

    fun setStateFalse() {
        viewModelScope.launch {
            _loginStateResponse.value = false
        }
    }
}
