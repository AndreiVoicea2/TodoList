package com.example.todolist

data class Todo(private var title : String, private var isChecked : Boolean = false)
{
     fun getTitle(): String
    {

        return this.title

    }

     fun setTitle(title: String)
    {

        this.title = title

    }

     fun getisChecked() : Boolean
    {

        return this.isChecked

    }

     fun setisChecked(isChecked: Boolean)
    {

        this.isChecked = isChecked

    }



}