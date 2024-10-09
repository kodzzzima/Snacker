package com.goals.goalapp.data.remote

import okhttp3.Credentials

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getInfo(login: String, password: String) = apiService.getInfo(Credentials.basic(login, password))
}
