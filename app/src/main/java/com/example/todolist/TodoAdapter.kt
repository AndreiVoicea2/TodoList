package com.example.todolist

import android.annotation.SuppressLint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class TodoAdapter(private val todos: MutableList<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()
{
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder
    {
       return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))
    }

    fun addTodo(todo : Todo)
    {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteDoneTodos()
    {
        todos.removeAll { todo ->
            todo.getisChecked()
        }

        notifyDataSetChanged()

    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean)
    {
        if(isChecked)
        {

            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG

        } else
        {

            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()

        }


    }


    override fun getItemCount(): Int {

        return todos.size

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val curTodo = todos[position]
        holder.itemView.apply{

            val tvTodoTitle: TextView = findViewById(R.id.tvTodoTitle)
            val cbDone: CheckBox = findViewById(R.id.cbDone)
            tvTodoTitle.text = curTodo.getTitle()
            cbDone.isChecked = curTodo.getisChecked()
            toggleStrikeThrough(tvTodoTitle, curTodo.getisChecked())
            cbDone.setOnCheckedChangeListener { _, isChecked ->


                toggleStrikeThrough(tvTodoTitle, isChecked)
                curTodo.setisChecked(!curTodo.getisChecked())


            }

        }

    }


}

