package com.example.todolist

data class Todo(private var title : String, private var isChecked : Boolean = false)
{
    init{

        setTitle(title)
        setisChecked(isChecked)

    }
     fun getTitle(): String
    {

        return this.title

    }

    fun setTitle(title: String)
    {
        if(title.isBlank())
        {

            this.title = "Default_Title"

        }else
        {

            this.title = title

        }

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