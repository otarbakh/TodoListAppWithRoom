package com.example.todolistupdated.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todolistupdated.entities.TodoModel


@Dao
interface TasksDao {
    @Query("SELECT * FROM tasks")
    fun getAll():LiveData<List<TodoModel>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTask(todoModel: TodoModel)
    @Query("DELETE FROM tasks")
    fun deleteAll()
    @Delete
    fun deleteTask(todoModel: TodoModel)
    @Update
    fun updateTodoModel(todoModel: TodoModel)
}