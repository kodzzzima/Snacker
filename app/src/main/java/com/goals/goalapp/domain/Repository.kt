package com.goals.goalapp.domain

import android.content.Context
import com.goals.goalapp.data.remote.ExampleJson2KtKotlin
import com.goals.goalapp.data.remote.RemoteDataSource
import com.goals.goalapp.utils.UiState
import com.goals.goalapp.utils.toResultFlow
import kotlinx.coroutines.flow.Flow

class Repository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getInfo(context: Context, login: String, password: String): Flow<UiState<ExampleJson2KtKotlin>> {
        return toResultFlow(context) {
            remoteDataSource.getInfo(login, password)
        }
    }
}
