package com.example.todolistupdated.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todolistupdated.databinding.AddTaskFragmentBinding
import com.example.todolistupdated.entities.TodoModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddTaskFragment: BottomSheetDialogFragment() {

    private var _binding: AddTaskFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<AddTaskViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddTaskFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener{
            val todoModel = TodoModel(
                0,
                binding.etTask.text.toString())
            viewModel.saveTask(todoModel)
            dismissAllowingStateLoss()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }
    companion object{
        const val KEY_ADD_FRAGMENT = "KEY_ADD_FRAGMENT"
    }
}