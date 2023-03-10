package com.example.lovecalculator.ui.utils

import android.content.Context

class Preferences(context: Context) {

    companion object {
        private const val HAVE_SEEN_ONBOARDING_KEY = "have_seen_onBoarding"
    }
    private val prefs = context.getSharedPreferences(
        "utils",
        Context.MODE_PRIVATE
    )

    fun setHaveSeenOnBoarding() {
        prefs.edit().putBoolean(HAVE_SEEN_ONBOARDING_KEY, true).apply()
    }
    fun getHaveSeenOnBoarding() = prefs.getBoolean(HAVE_SEEN_ONBOARDING_KEY, false)

}