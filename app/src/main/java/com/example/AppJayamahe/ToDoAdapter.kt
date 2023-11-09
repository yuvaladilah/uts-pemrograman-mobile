package com.example.AppJayamahe

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.CheckBox


class ToDoAdapter(

    private val todos: MutableList<ToDo>

) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class   ToDoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var todotitle: TextView = itemView.findViewById(R.id.tvTodoTitle)
        var cbdone: CheckBox = itemView.findViewById(R.id.cbDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    fun AddToDo(toDo: ToDo){
        todos.add(toDo)
        notifyItemInserted(todos.size-1)
    }

    fun deleteDoneToDos(){
        todos.removeAll{toDo -> toDo.isChecked }
        notifyDataSetChanged()
    }


    private fun toggleStrikeThrough( tvToDoTitle: TextView, isChecked:Boolean){
        if (isChecked){
            tvToDoTitle.paintFlags = tvToDoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }
        else{
            tvToDoTitle.paintFlags = tvToDoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }


    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val curToDo = todos[position]
        holder.apply {
            todotitle.text = curToDo.title
            cbdone.isChecked = curToDo.isChecked
            toggleStrikeThrough(todotitle, curToDo.isChecked)
            cbdone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(todotitle, isChecked)
                curToDo.isChecked = !curToDo.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}