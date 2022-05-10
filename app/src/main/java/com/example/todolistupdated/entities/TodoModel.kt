package com.example.todolistupdated.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val task: String
)
