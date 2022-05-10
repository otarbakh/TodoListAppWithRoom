package com.example.todolistupdated.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolistupdated.dao.TasksDao
import com.example.todolistupdated.entities.TodoModel

const val DATABASE_VERSION = 1

@Database(entities = [TodoModel::class], version = DATABASE_VERSION, exportSchema = false)

abstract class TasksDatabase: RoomDatabase() {
    abstract fun taskDao():TasksDao

    companion object{
        @Volatile
        private var INSTANCE: TasksDatabase? = null
        fun getDatabase(context: Context):TasksDatabase{
            var tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val newInstance = Room.databaseBuilder(context, TasksDatabase::class.java, "tasks").allowMainThreadQueries().build()
                INSTANCE = newInstance
                return newInstance
            }

        }
    }

}