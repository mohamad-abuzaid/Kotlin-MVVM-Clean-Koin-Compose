package com.compose.clean.data.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
class PlaceholderConverter {

    @TypeConverter
    fun stringToSetting(data: String?): Any? {
        val gson = Gson()
        if (data == null) {
            return null
        }
        val listType: Type = object : TypeToken<Any?>() {}.type
        return gson.fromJson<Any?>(data, listType)
    }

    @TypeConverter
    fun settingToString(myObjects: Any?): String? {
        val gson = Gson()
        return gson.toJson(myObjects)
    }
}