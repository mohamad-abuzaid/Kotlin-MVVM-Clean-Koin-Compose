package gov.sa.scisp.data.storage

import android.content.Context
import gov.sa.scisp.domain.utils.storage.ILocalPreferencesStorage
import gov.sa.scisp.domain.utils.storage.Preference

/**
 * Created by "Mohamad Abuzaid" on 07/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class PreferencesStorage  constructor(context: Context) : ILocalPreferencesStorage {
    private val prefs = context.getSharedPreferences(
        context.packageName,
        Context.MODE_PRIVATE
    )

   override fun clear() {
        val uuid = this.getValue(Preference.UNIQUE_DEVICE_ID, "")
        val edit = prefs.edit()
        edit.clear()
        edit.apply()
        this.putValue(Preference.UNIQUE_DEVICE_ID, uuid)
    }

    override fun <T> putValue(key: String, value: T) {
        when (value) {
            is Int -> prefs.edit().putInt(key, value).apply()
            is String -> prefs.edit().putString(key, value).apply()
            is Boolean -> prefs.edit().putBoolean(key, value).apply()
            is Long -> prefs.edit().putLong(key, value).apply()
        }
    }

    override fun <T> getValue(key: String?, defaultValue: T): T {
        return when (defaultValue) {
            is Int -> prefs.getInt(key, defaultValue)
            is String -> prefs.getString(key, defaultValue)
            is Boolean -> prefs.getBoolean(key, defaultValue)
            is Long -> prefs.getLong(key, defaultValue)
            else ->
                return defaultValue
        } as T
    }
}