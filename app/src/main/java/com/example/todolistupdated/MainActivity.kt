package com.example.todolistupdated

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistupdated.databinding.ActivityMainBinding
import com.example.todolistupdated.entities.TodoModel
import com.example.todolistupdated.fragments.AddTaskFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoListAdapter: TodoListAdapter
    private val bviewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.add.setOnClickListener {
            AddTaskFragment().show(supportFragmentManager,AddTaskFragment.KEY_ADD_FRAGMENT)
        }

        todoListAdapter = TodoListAdapter().apply {
            todoListAdapter = TodoListAdapter().apply {
                setDeleteClickListener {
                    bviewModel.deleteTaskItem(it)
                }
            }
        }


        binding.rvTasks.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvTasks.adapter = todoListAdapter
        bviewModel.getTasksLiveData().observe(this){
            drawRecyclerView(it)
        }
    }



    fun drawRecyclerView(todolistItems:List<TodoModel>){
        todoListAdapter.updateAll(todolistItems)
    }
}