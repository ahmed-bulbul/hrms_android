package com.walton.smarthrm.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SharedPreferenceInfo(context: Context) {

    private var context: Context? = context
    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    fun storeToken(token: String, key: String?) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        editor.putString(key, token)
        editor.apply()
    }

    fun getToken(key: String?): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(key, "")
    }

}