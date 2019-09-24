package com.example.todoplanner

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private var TAG = "TodoView Holder"

    fun bind( todo: ToDo){
        view.findViewById<TextView>(R.id.text_title).text = todo.title
        Log.i(TAG, todo.title)
        view.findViewById<TextView>(R.id.text_description).text = todo.description
        view.findViewById<TextView>(R.id.text_date).text = todo.date
    }
}