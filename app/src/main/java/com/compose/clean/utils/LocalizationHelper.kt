package com.compose.clean.utils

import android.content.Context
import java.util.Locale

/**
 * Created by "Mohamad Abuzaid" on 23/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
object LocalizationHelper {
    fun setLocale(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val config = context.resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)

        return context.createConfigurationContext(config)
    }
}