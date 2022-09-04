package vn.thonghkk.noteapp.local.repositories

import vn.thonghkk.noteapp.local.db.entities.TaskEntity

interface TaskRepository {

    suspend fun insertTask(taskEntity: TaskEntity)

    suspend fun updateTask(taskEntity: TaskEntity)

    suspend fun deleteTask(idTask: Int)

    suspend fun searchTaskByName(nameTask: String): List<TaskEntity>

    suspend fun getAllTask(): List<TaskEntity>

}