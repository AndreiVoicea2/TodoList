package com.example.todolist

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodoItems: RecyclerView = findViewById(R.id.rvTodoItems)
        val todoAdapter = TodoAdapter(mutableListOf())
        val btnAddTodo: Button = findViewById(R.id.btnAddTodo)
        val dateButton: Button = findViewById(R.id.datePickerButton)
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val myCalendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        }

        todoAdapter.LoadFromDataBase()

        dateButton.setOnClickListener{

            DatePickerDialog(this, datePickerDialog, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()


        }


        btnAddTodo.setOnClickListener{

            val etTodoTitle: EditText = findViewById(R.id.etTodoTitle)
            val todoTitle = etTodoTitle.text.toString()

            val todo = Todo(todoTitle, myCalendar.time)

            todoAdapter.addTodo(todo)
            etTodoTitle.text.clear()


        }



    }

}

