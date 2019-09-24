package com.example.todoplanner

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    val TAG = "ViewModel Todo"
    var cnt = 0

    var todos: MutableList<ToDo> = mutableListOf(ToDo("Title", "Description", "Date"),

            ToDo("Grocery2", "By groceries on the way home", "19/2/2019"),
            ToDo("Grocery3", "By groceries on the way home", "19/2/2019"))

    var allTodos: LiveData<List<ToDo>>

    private val repository: TodoRepository

    init {
        val todoDao = TodoDatabase.getDatabase(application, viewModelScope).todoDAO()
        repository = TodoRepository(todoDAO = todoDao)
        allTodos = repository.allTodos
    }


    fun insert(todo: ToDo)= viewModelScope.launch {
        repository.insert(todo)
    }
}