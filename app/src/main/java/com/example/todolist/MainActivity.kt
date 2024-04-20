package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.ui.theme.TodoListTheme


private lateinit var todoAdapter: TodoAdapter
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val rvTodoItems: RecyclerView = findViewById(R.id.rvTodoItems)
        todoAdapter = TodoAdapter(mutableListOf())
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btnAddTodo: Button = findViewById(R.id.btnAddTodo)
                btnAddTodo.setOnClickListener{

                    val etTodoTitle: EditText = findViewById(R.id.etTodoTitle)
                    val todoTitle = etTodoTitle.text.toString()
                    if(todoTitle.isNotEmpty())
                    {

                        val todo = Todo(todoTitle)
                        todoAdapter.addTodo(todo)
                        etTodoTitle.text.clear()

                    }


                }

        val btnDeleteDoneTodos: Button = findViewById(R.id.btnDeleteDoneTodos)
        btnDeleteDoneTodos.setOnClickListener{

            todoAdapter.deleteDoneTodos()

        }

    }
}

