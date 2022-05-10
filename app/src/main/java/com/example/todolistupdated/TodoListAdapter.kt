package com.example.todolistupdated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistupdated.databinding.TaskItemLayoutBinding
import com.example.todolistupdated.entities.TodoModel

class TodoListAdapter: RecyclerView.Adapter<TodoListAdapter.TodolistViewHolder>() {

    private val currentList = mutableListOf<TodoModel>()
    private lateinit var onDeleteClickListener:(TodoModel) -> Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodolistViewHolder {
        val binding =
            TaskItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodolistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodolistViewHolder, position: Int) {

        holder.bindData(currentList[position])

    }

    fun setDeleteClickListener(listener: (TodoModel) -> Unit) {
        this.onDeleteClickListener = listener
    }

    fun updateAll(list:List<TodoModel>){
        currentList.clear()
        currentList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    inner class TodolistViewHolder(private val binding: TaskItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(todoModel: TodoModel){
            binding.tvTaskName.text = todoModel.task
        }

    }
}
