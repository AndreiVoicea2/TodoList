package com.example.todolist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Locale


object TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()
{
    private val todos: MutableList<Todo> = mutableListOf()
    private var  database: DatabaseReference = FirebaseDatabase.getInstance().getReference("Todos")
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder
    {
       return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))
    }

    fun loadFromDataBase()
    {

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                todos.clear()

                for (data in snapshot.children) {
                    val todo = data.getValue(Todo::class.java)
                    todo?.let { addTodo(it) }
                }


                notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("MainActivity", "loadTodos:onCancelled", error.toException())
            }
        })

    }


    fun addTodo(todo : Todo)
    {
        var sameTitle = false

        for(eachTodo: Todo in todos)
        {

            if(todo.getTitle().trim().lowercase(Locale.getDefault()) == eachTodo.getTitle().trim().lowercase(Locale.getDefault()))
            {

                sameTitle = true

            }

            if(sameTitle)
            {

                break

            }

        }

        if(!sameTitle) {

            todos.add(todo)
            database.child(todo.getTitle()).setValue(todo)
            notifyItemInserted(todos.size - 1)

        }
    }

    override fun getItemCount(): Int {

        return todos.size

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val curTodo = todos[position]
        holder.itemView.apply{

            val tvTodoTitle: TextView = findViewById(R.id.tvTodoTitle)
            val tvTodoDate: TextView = findViewById(R.id.tvTodoDate)
            val cbDone: CheckBox = findViewById(R.id.cbDone)


            tvTodoTitle.text = curTodo.getTitle()
            val myFormat = "dd-MM-yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.UK)
            tvTodoDate.text = sdf.format(curTodo.getDate())
            cbDone.isChecked = curTodo.getisChecked()



            cbDone.setOnCheckedChangeListener { _, _ ->


                database.child(curTodo.getTitle()).removeValue()
                todos.remove(curTodo)



            }

        }

    }


}

