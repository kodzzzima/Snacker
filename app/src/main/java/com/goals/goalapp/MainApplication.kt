package com.goals.goalapp

import android.app.Application
import com.goals.goalapp.di.dispatcherModule
import com.goals.goalapp.di.networkModule
import com.goals.goalapp.di.remoteDataSourceModule
import com.goals.goalapp.di.userModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module

class MainApplication : Application() {

    private val moduleList: List<Module> = listOf(
        dispatcherModule,
        userModule,
        networkModule,
        remoteDataSourceModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(moduleList)
        }
    }
}
