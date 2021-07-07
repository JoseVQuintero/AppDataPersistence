package com.danisable.appdatapersistence.utils

import android.content.Context
import android.content.SharedPreferences

object Utils {
    const val PREF_DARK_MODE = "darkMode"
    const val PREF_USER = "pref_user"
    private const val PREF_DEFAULT = ""
    fun setPreferencesAppData(context: Context, key: String, value: Boolean){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_USER, 0)
        val editor = sharedPreferences.edit()
        editor.putString(key,value.toString())
        editor.apply()
    }

    fun getPreferencesAppData(context: Context, key: String): String? {
        val sharePreferences: SharedPreferences = context.getSharedPreferences(PREF_USER,0)
        return sharePreferences.getString(key, PREF_USER)
    }
}