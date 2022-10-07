package com.study.compose.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.time.LocalDateTime

@Entity(tableName = "workers")
data class WorkerEntity(
    @PrimaryKey
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    val id : Long,

    @ColumnInfo(name = "email", typeAffinity = ColumnInfo.TEXT)
    var email : String,

    @ColumnInfo(name = "password", typeAffinity = ColumnInfo.TEXT)
    var password : String,

    @ColumnInfo(name = "level", typeAffinity = ColumnInfo.INTEGER)
    var level : Int,

    @ColumnInfo(name = "workerName", typeAffinity = ColumnInfo.TEXT)
    var workerName : String,

    @ColumnInfo(name = "profileImage", typeAffinity = ColumnInfo.BLOB)
    var profileImage : ByteArray?,

    @ColumnInfo(name = "syncDate", typeAffinity = ColumnInfo.TEXT)
    @field:TypeConverters(DateConverters::class)
    var syncDate : LocalDateTime
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WorkerEntity

        if (id != other.id) return false
        if (email != other.email) return false
        if (password != other.password) return false
        if (level != other.level) return false
        if (workerName != other.workerName) return false
        if (profileImage != null) {
            if (other.profileImage == null) return false
            if (!profileImage.contentEquals(other.profileImage)) return false
        } else if (other.profileImage != null) return false
        if (syncDate != other.syncDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + level
        result = 31 * result + workerName.hashCode()
        result = 31 * result + (profileImage?.contentHashCode() ?: 0)
        result = 31 * result + syncDate.hashCode()
        return result
    }


}