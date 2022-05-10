package com.example.todolistupdated.tasksRepository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.todolistupdated.database.TasksDatabase
import com.example.todolistupdated.entities.TodoModel

class TasksRepository(context: Context) {

    private val database = TasksDatabase.getDatabase(context)

    suspend fun insertTask(todoModel:TodoModel){
        database.taskDao().insertTask(todoModel)
    }

    suspend fun getAllTasks(): LiveData<List<TodoModel>> {
        return database.taskDao().getAll()
    }

    suspend fun deleteTask(todoModel: TodoModel){
        database.taskDao().deleteTask(todoModel)
    }

    companion object{
        private var instance: TasksRepository? = null

        fun getInstance(context: Context):TasksRepository{
            return if (instance != null ){
                instance!!
            }else{
                instance = TasksRepository(context)
                instance!!
            }
        }
    }

}