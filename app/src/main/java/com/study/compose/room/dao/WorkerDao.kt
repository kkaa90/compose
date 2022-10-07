package com.study.compose.room.dao

import androidx.room.*
import com.study.compose.room.entity.WorkerEntity
import com.study.compose.room.entity.WorkerSkillsEntity

@Dao
interface WorkerDao {
    @Query("select w.id as id, w.email as email, w.password as password from workers w limit 1")
    fun getExistWorkerLoginInfo() : LoginInfo?

    @Query("select * from workers limit 1")
    fun getWorker(): WorkerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveWorker(worker: WorkerEntity)

    @Update
    fun updateWorker(worker : WorkerEntity)

    @Delete
    fun deleteWorker(worker : WorkerEntity)


    data class LoginInfo(val id : Long, val email : String, val password : String)

    @Query("select * from skills where workerId = :workerId")
    fun getWorkerSkills(workerId : Long) : List<WorkerSkillsEntity>?

    @Query("select * from skills where id = :id")
    fun getWorkerSkillById(id : Long) : WorkerSkillsEntity

    @Query("select id from skills where workerId = :workerId")
    fun getWorkerSkillIdByWorkerId(workerId : Long) : List<Long>?

    @Query("select * from skills where workerId = :workerId and name like :keyword")
    fun searchWorkerSkillByKeyword(workerId: Long, keyword : String) : List<WorkerSkillsEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWorkerSkill(skill : WorkerSkillsEntity)

    @Query("update skills set level = :nextLevel where id = :id")
    fun updateWorkerSkillLevelById(id: Long, nextLevel : Int)

    @Delete
    fun deleteWorkerSkill(skill : WorkerSkillsEntity)
}