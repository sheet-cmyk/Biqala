package com.grocery.app.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.Locale

object LocaleHelper {

    private const val PREF_LANG = "selected_language"

    fun setLocale(context: Context, languageCode: String) {
        saveLanguage(context, languageCode)
        updateResources(context, languageCode)
        // Restart MainActivity to apply immediately
        val intent = context.packageManager
            .getLaunchIntentForPackage(context.packageName)
        intent?.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }

    fun onAttach(context: Context): Context {
        val lang = getSelectedLanguage(context)
        return updateResources(context, lang)
    }

    fun getSelectedLanguage(context: Context): String {
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        return prefs.getString(PREF_LANG, "ar") ?: "ar"
    }

    private fun saveLanguage(context: Context, lang: String) {
        context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            .edit().putString(PREF_LANG, lang).apply()
    }

    private fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.createConfigurationContext(config)
        } else {
            @Suppress("DEPRECATION")
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
            context
        }
    }
}
