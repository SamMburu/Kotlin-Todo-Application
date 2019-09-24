package com.example.todoplanner

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoAdapter(context: Context) : ListAdapter<ToDo, TodoViewHolder>(MCallBack) {

    private val TAG = "Todo Adapter"

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val holder = TodoViewHolder(inflater.inflate(R.layout.item_todo, parent, false))
        return holder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
        Log.i(TAG, getItem(position).title)
    }

}