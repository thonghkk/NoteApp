package vn.thonghkk.noteapp.ui.home

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vn.thonghkk.noteapp.local.db.entities.TaskEntity
import vn.thonghkk.noteapp.local.repositories.TaskRepository

class HomeViewModel(private val taskRepository: TaskRepository): ViewModel() {


    private var _listTask = MutableLiveData<List<TaskEntity>>()

    val listTask: LiveData<List<TaskEntity>> get() = _listTask


    init {
        initGetAllTaskInDB()
    }

    private fun initGetAllTaskInDB() {
        viewModelScope.launch(Dispatchers.IO) {
            _listTask.postValue(taskRepository.getAllTask())
        }
    }

    fun insertNewTask(taskEntity: TaskEntity) {
        viewModelScope.launch(Dispatchers.Default) {
            taskRepository.insertTask(taskEntity)
        }
    }

    private fun updateTask(taskEntity: TaskEntity) {
        viewModelScope.launch {
            taskRepository.updateTask(taskEntity)
        }
    }

    private fun searchTaskByName(nameTask: String) {
        viewModelScope.launch {
            _listTask.postValue(taskRepository.searchTaskByName(nameTask))
        }
    }

    private fun deleteTaskById(idTaskEntity: Int) {
        viewModelScope.launch {
            taskRepository.deleteTask(idTaskEntity)
        }
    }
}