package com.example.AppJayamahe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ToDoListActivity : AppCompatActivity() {


    private lateinit var todoAdapter: ToDoAdapter
    private lateinit var rvtodoitems: RecyclerView
    private lateinit var ettodotitle: EditText
    private lateinit var btnaddtodo: Button
    private lateinit var btndeltodo: Button
    private lateinit var backhome: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        rvtodoitems = findViewById(R.id.RVToDoItems)
        ettodotitle = findViewById(R.id.ETToDoTitle)
        btnaddtodo = findViewById(R.id.btnAddToDo)
        btndeltodo = findViewById(R.id.btnDelToDo)
        backhome = findViewById(R.id.back_home)

        todoAdapter = ToDoAdapter(mutableListOf())


        rvtodoitems.adapter = todoAdapter
        rvtodoitems.layoutManager = LinearLayoutManager(this)

        btnaddtodo.setOnClickListener{
            val todotitle = ettodotitle.text.toString()
            if(todotitle.isNotEmpty()){
                val todo = ToDo(todotitle)
                todoAdapter.AddToDo(todo)
                ettodotitle.text.clear()
            }
        }
        btndeltodo.setOnClickListener{
            todoAdapter.deleteDoneToDos()
        }

        backhome.setOnClickListener {
            val intent = Intent(this, DashboardFragment::class.java)
            startActivity(intent)
        }
    }

}