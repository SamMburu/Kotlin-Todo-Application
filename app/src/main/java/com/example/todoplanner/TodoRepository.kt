package com.example.todoplanner

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDAO: TodoDAO) {

    val allTodos: LiveData<List<ToDo>> = todoDAO.getAll()

    suspend fun insert(toDo: ToDo){
        todoDAO.insert(toDo)
    }
}