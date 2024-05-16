package com.example.todolist

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testGetSetTitle() {
        val todo = Todo("Example Todo")
        assertEquals("Example Todo", todo.getTitle())

        todo.setTitle("Updated Todo")
        assertEquals("Updated Todo", todo.getTitle())
    }

    @Test
    fun testGetSetIsChecked() {
        val todo = Todo("Example Todo")
        assertFalse(todo.getisChecked())

        todo.setisChecked(true)
        assertTrue(todo.getisChecked())
    }
}

class TodoAdapterTest {

    @Test
    fun testAddTodo() {
        val adapter = TodoAdapter(mutableListOf())
        val todo = Todo("Example Todo")
        adapter.addTodo(todo)
        assertEquals(1, adapter.itemCount)
    }


}