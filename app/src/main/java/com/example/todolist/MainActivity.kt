package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodoItems: RecyclerView = findViewById(R.id.rvTodoItems)
        val todoAdapter = TodoAdapter(mutableListOf())
        val btnAddTodo: Button = findViewById(R.id.btnAddTodo)
        val btnDeleteDoneTodos: Button = findViewById(R.id.btnDeleteDoneTodos)
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)



        btnAddTodo.setOnClickListener{

            val etTodoTitle: EditText = findViewById(R.id.etTodoTitle)
            val todoTitle = etTodoTitle.text.toString()

            val todo = Todo(todoTitle)
            todoAdapter.addTodo(todo)
            etTodoTitle.text.clear()


        }


        btnDeleteDoneTodos.setOnClickListener{

            todoAdapter.deleteDoneTodos()

        }

    }
}

