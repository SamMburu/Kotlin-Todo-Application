package com.example.todoplanner

import androidx.recyclerview.widget.DiffUtil

val MCallBack = object: DiffUtil.ItemCallback<ToDo>(){
    override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean = oldItem == newItem

}