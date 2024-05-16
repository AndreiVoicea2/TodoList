package com.example.todolist

import java.util.Calendar
import java.util.Date


data class Todo(private var title : String, private var date:Date = Calendar.getInstance().time, private var isChecked : Boolean = false)
{

    constructor() : this("")
    init{

        setTitle(title)
        setisChecked(isChecked)
        setDate(date)

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

    fun getDate(): Date
    {

        return this.date

    }

    fun setDate(date: Date)
    {

        this.date = date

    }


}