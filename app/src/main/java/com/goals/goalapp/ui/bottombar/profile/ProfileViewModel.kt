package com.goals.goalapp.ui.bottombar.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goals.goalapp.data.local.PreferencesHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ProfileState(
    val data: ProfileUIData? = null,
    val isLoading: Boolean = true,
    val isExit: Boolean = false,
    val isFriendsAction: Boolean = false,
)

data class ProfileUIData(
    val firstName: String,
    val secondName: String,
    val userName: String,
    val email: String,
    val balance: Int,
    val friends: List<String>,
)

class ProfileViewModel(
    private val preferencesHelper: PreferencesHelper,
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> get() = _state.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        _state.update {
            it.copy(
                data = ProfileUIData(
                    firstName = "Василий",
                    secondName = "Пупкин",
                    userName = "loh228",
                    email = "my.personal@yandex.ru",
                    balance = 3,
                    friends = listOf("")
                )
            )
        }
    }

    fun onExitClick() {
        viewModelScope.launch {
            preferencesHelper.putLogAndPass(null, null)
            _state.update { it.copy(isExit = true) }
        }
    }

    fun onFriendsClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isFriendsAction = true) }
        }
    }

    fun onFriendsClickHandled() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isFriendsAction = false) }
        }
    }

    fun setExitStateFalse() {
        viewModelScope.launch {
            _state.update { it.copy(isExit = false) }
        }
    }
}
