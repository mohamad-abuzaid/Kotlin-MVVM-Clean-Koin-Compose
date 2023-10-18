package com.compose.clean.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.compose.clean.data.database.converters.PlaceholderConverter
import com.compose.clean.data.database.daos.PlaceholderDAO
import com.compose.clean.data.database.entities.PlaceholderEntity

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
@Database(
    entities = [PlaceholderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    PlaceholderConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun placeholderDAO(): PlaceholderDAO

    companion object {
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                return Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration().build()
            }
        }
    }
}