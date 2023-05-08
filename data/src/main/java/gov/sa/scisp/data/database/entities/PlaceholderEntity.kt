package gov.sa.scisp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by "Mohamad Abuzaid" on 06/05/2023.
 * Email: mabuzaid@sure.com.sa
 */
@Entity(tableName = "any_table")
data class PlaceholderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val baseUrl: String?
) : Serializable