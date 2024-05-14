package com.example.todolist

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Calendar


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodoItems: RecyclerView = findViewById(R.id.rvTodoItems)
        val todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        todoAdapter.LoadFromDataBase()

        setupUI(todoAdapter)
    }

    private fun setupUI(todoAdapter: TodoAdapter) {

        val btnAddTodo: Button = findViewById(R.id.btnAddTodo)
        val dateButton: Button = findViewById(R.id.datePickerButton)
        val myCalendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }

        dateButton.setOnClickListener {
            DatePickerDialog(this, datePickerDialog, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        btnAddTodo.setOnClickListener {
            val etTodoTitle: EditText = findViewById(R.id.etTodoTitle)
            val todoTitle = etTodoTitle.text.toString()
            val todo = Todo(todoTitle, myCalendar.time)

            todoAdapter.addTodo(todo)
            etTodoTitle.text.clear()
        }
    }

}

