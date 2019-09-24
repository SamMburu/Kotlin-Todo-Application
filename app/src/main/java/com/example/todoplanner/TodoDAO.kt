package com.example.todoplanner

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface TodoDAO {

    @Query("SELECT * FROM TodoTable")
    fun getAll(): LiveData<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg todo: ToDo)
}