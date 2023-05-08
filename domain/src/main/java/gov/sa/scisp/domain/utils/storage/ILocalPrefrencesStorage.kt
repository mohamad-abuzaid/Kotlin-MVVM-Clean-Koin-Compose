package gov.sa.scisp.domain.utils.storage

/**
 * Created by "Mohamad Abuzaid" on 07/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
interface ILocalPreferencesStorage {
    fun <T> putValue(key: String, value: T)
    fun <T> getValue(key: String?, defaultValue: T): T
    fun clear()
}