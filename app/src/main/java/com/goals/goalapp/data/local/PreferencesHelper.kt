package com.goals.goalapp.data.local

import android.content.Context

class PreferencesHelper(
    context: Context,
) {
    private val sharedPreferences = context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE)

    private val PREF_KEY_LOGIN = "PREF_KEY_LOGIN"
    private val PREF_KEY_PASS = "PREF_KEY_PASS"

    fun getLogAndPass(): PrefParams? {
        val login = sharedPreferences.getString(PREF_KEY_LOGIN, null)
        val password = sharedPreferences.getString(PREF_KEY_PASS, null)
        return if (login != null && password != null) {
            return PrefParams(login, password)
        } else null
    }

    fun putLogAndPass(login: String?, pass: String?) {
        with(sharedPreferences.edit()) {
            putString(PREF_KEY_LOGIN, login)
            putString(PREF_KEY_PASS, pass)
            apply()
        }
    }
}

data class PrefParams(
    val log: String,
    val pass: String,
)
