package com.example.todolistupdated

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todolistupdated.entities.TodoModel
import com.example.todolistupdated.tasksRepository.TasksRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val tasksRepository = TasksRepository.getInstance(application)
    private lateinit var todoLiveData: LiveData<List<TodoModel>>

    init {
        viewModelScope.launch {
            todoLiveData = tasksRepository.getAllTasks()
        }
    }

    fun getTasksLiveData(): LiveData<List<TodoModel>> {
        return todoLiveData!!
    }

    fun deleteTaskItem(todoModel: TodoModel ){
        viewModelScope.launch{
            tasksRepository.deleteTask(todoModel)
        }

    }
}