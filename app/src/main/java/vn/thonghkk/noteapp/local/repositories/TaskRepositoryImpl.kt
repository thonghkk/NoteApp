package vn.thonghkk.noteapp.local.repositories

import vn.thonghkk.noteapp.local.db.dao.TaskDao
import vn.thonghkk.noteapp.local.db.entities.TaskEntity

class TaskRepositoryImpl(private val taskDao: TaskDao): TaskRepository {
    override suspend fun insertTask(taskEntity: TaskEntity) {
        taskDao.insertTask(taskEntity)
    }

    override suspend fun updateTask(taskEntity: TaskEntity) {
        taskDao.updateTask(taskEntity)
    }

    override suspend fun deleteTask(idTask: Int) {
        taskDao.deleteTask(idTask)
    }

    override suspend fun searchTaskByName(nameTask: String): List<TaskEntity> {
        return taskDao.searchTaskByName(nameTask)
    }

    override suspend fun getAllTask(): List<TaskEntity> {
        return taskDao.getAllTask()
    }
}