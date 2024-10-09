package com.goals.goalapp.data.remote

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("info")
    suspend fun getInfo(@Header("Authorization") token: String): Response<ExampleJson2KtKotlin>
}

data class ExampleJson2KtKotlin(

    @SerializedName("id") var id: String? = null,
    @SerializedName("firstName") var firstName: String? = null,
    @SerializedName("secondName") var secondName: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("balance") var balance: Int? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("friends") var friends: ArrayList<String> = arrayListOf(),
    @SerializedName("password") var password: String? = null,
    @SerializedName("loggedIn") var loggedIn: Boolean? = null,
    @SerializedName("friendRequestsFrom") var friendRequestsFrom: ArrayList<String> = arrayListOf(),
    @SerializedName("friendRequestsTo") var friendRequestsTo: ArrayList<String> = arrayListOf(),
    @SerializedName("orders") var orders: ArrayList<String> = arrayListOf(),
    @SerializedName("enabled") var enabled: Boolean? = null,
    @SerializedName("authorities") var authorities: String? = null,
    @SerializedName("accountNonExpired") var accountNonExpired: Boolean? = null,
    @SerializedName("accountNonLocked") var accountNonLocked: Boolean? = null,
    @SerializedName("credentialsNonExpired") var credentialsNonExpired: Boolean? = null

)
