package com.study.compose.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.study.compose.room.dao.WorkerDao
import com.study.compose.room.entity.DateConverters
import com.study.compose.room.entity.WorkerEntity
import com.study.compose.room.entity.WorkerSkillsEntity

@Database(entities = [WorkerEntity::class, WorkerSkillsEntity::class], version = 1)
abstract class AppDataBase :RoomDatabase() {
    abstract fun workerDao() : WorkerDao
}