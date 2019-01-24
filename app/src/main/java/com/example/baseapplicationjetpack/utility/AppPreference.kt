package com.example.baseapplicationjetpack.utility

import android.content.Context
import android.content.SharedPreferences
import com.example.baseapplicationjetpack.data.constants.Preference
import javax.inject.Inject

class AppPreference @Inject constructor(var context: Context){
    private var preferences: SharedPreferences = context.getSharedPreferences(
        com.example.baseapplicationjetpack.data.constants.Preference.PREFERENCE_NAME, Context
            .MODE_PRIVATE
    )

    var testPreference : String
        get() = preferences.getString(Preference.TEST_PREFERENCE, "Error")
        set(value) = preferences.edit().putString(Preference.TEST_PREFERENCE,value).apply()

}