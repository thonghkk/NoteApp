package vn.thonghkk.noteapp.local.db.dao

import androidx.room.*
import vn.thonghkk.noteapp.local.db.entities.TaskEntity

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

    @Query("DELETE FROM TASK WHERE id = :idTask")
    suspend fun deleteTask(idTask: Int)

    @Query("SELECT * FROM task WHERE name = :nameTask")
    suspend fun searchTaskByName(nameTask: String): List<TaskEntity>

    @Query("SELECT * FROM task ORDER BY createdTime DESC")
    fun getAllTask(): List<TaskEntity>
}