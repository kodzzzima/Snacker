package com.goals.goalapp.di

import com.goals.goalapp.data.local.PreferencesHelper
import com.goals.goalapp.data.remote.RemoteDataSource
import com.goals.goalapp.domain.Repository
import com.goals.goalapp.login.domain.UserRepository
import com.goals.goalapp.login.presentation.LoginViewModel
import com.goals.goalapp.ui.bottombar.profile.ProfileViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userModule = module {

    viewModel { LoginViewModel(get(), get(), get()) }

    single { UserRepository() }

    single { Repository(get()) }

    viewModel { ProfileViewModel(get()) }

    single {
        PreferencesHelper(androidApplication())
    }
}

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}
