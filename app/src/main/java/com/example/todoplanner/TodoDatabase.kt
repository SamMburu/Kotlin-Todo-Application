package com.example.todoplanner

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = arrayOf(ToDo::class), version = 1)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun todoDAO(): TodoDAO

    private class TodoDatabaseCallback(
        private val scope: CoroutineScope): RoomDatabase.Callback(){

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let{ database -> scope.launch {
                var todoDAO = database.todoDAO()

                var todo = ToDo("Grocery1", "By groceries on the way home", "19/2/2019")
                todoDAO.insert(todo)
                todo = ToDo("Grocery2", "By groceries on the way home", "20/2/2019")
                todoDAO.insert(todo)
                todo = ToDo("Grocery3", "By groceries on the way home", "23/2/2019")
                todoDAO.insert(todo)
            }
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: TodoDatabase?= null

        fun getDatabase(context: Context,
                        scope: CoroutineScope): TodoDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "TodoDatabase"
                ).addCallback(TodoDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}


