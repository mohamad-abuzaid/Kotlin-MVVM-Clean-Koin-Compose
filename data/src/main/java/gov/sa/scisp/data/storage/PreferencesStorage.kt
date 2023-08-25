package gov.sa.scisp.data.storage

import android.content.Context
import gov.sa.scisp.domain.utils.storage.ILocalPreferencesStorage
import gov.sa.scisp.domain.utils.storage.Preference

/**
 * Created by "Mohamad Abuzaid" on 07/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class PreferencesStorage constructor(context: Context) : ILocalPreferencesStorage {
    private val prefs = context.getSharedPreferences(
        context.packageName,
        Context.MODE_PRIVATE
    )

    override fun clear() {
        val uuid = this.getString(Preference.UNIQUE_DEVICE_ID, "")
        val edit = prefs.edit()
        edit.clear()
        edit.apply()
        this.putString(Preference.UNIQUE_DEVICE_ID, uuid)
    }

    override fun putInt(key: String, value: Int) {
        prefs.edit().putInt(key, value).apply()
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return prefs.getInt(key, defaultValue)
    }

    override fun putLong(key: String, value: Long) {
        prefs.edit().putLong(key, value).apply()
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        return prefs.getLong(key, defaultValue)
    }

    override fun putString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    override fun getString(key: String, defaultValue: String): String {
        return prefs.getString(key, defaultValue) ?: defaultValue
    }

    override fun putBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    override fun clearToken() {
        prefs.edit().remove(Preference.USER_TOKEN).apply()
        prefs.edit().remove(Preference.USER_REFRESH_TOKEN).apply()
    }
}