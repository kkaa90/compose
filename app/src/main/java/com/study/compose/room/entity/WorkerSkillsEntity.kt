package com.study.compose.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "skills", foreignKeys = [ForeignKey(
        entity = WorkerEntity::class, parentColumns = arrayOf("id"),
        childColumns = arrayOf("workerId"), onDelete = ForeignKey.CASCADE
    )]
)
data class WorkerSkillsEntity(
    @PrimaryKey
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    var id: Long,

    @ColumnInfo(name = "workerId", typeAffinity = ColumnInfo.INTEGER)
    val workerId: Long,

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    var name: String,

    @ColumnInfo(name = "level", typeAffinity = ColumnInfo.INTEGER)
    var level: Int
)