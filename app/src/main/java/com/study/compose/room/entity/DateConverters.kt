package com.study.compose.room.entity

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DateConverters {
    val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    @TypeConverter
    fun dateToString(localDateTime : LocalDateTime?): String? {
        return localDateTime?.format(pattern)
    }

    @TypeConverter
    fun stringToDate(string: String): LocalDateTime? {
        return string?.let { LocalDateTime.parse(it, pattern) }
    }
}