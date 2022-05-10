package com.example.todolistupdated.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistupdated.entities.TodoModel
import com.example.todolistupdated.tasksRepository.TasksRepository
import kotlinx.coroutines.launch

class AddTaskViewModel(application: Application): AndroidViewModel(application) {
    private val todoRepository = TasksRepository.getInstance(application)
    fun saveTask(todoModel:TodoModel){
        viewModelScope.launch {
            todoRepository.insertTask(todoModel)
        }
    }

}