package com.jbhifitech.writeme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jbhifitech.writeme.R
import com.jbhifitech.writeme.db.Note

class NoteAdapter(var context: Context, var list: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title : TextView
        var notes : TextView

        init {
            title = itemView.findViewById(R.id.itemtitle)
            notes = itemView.findViewById(R.id.itemnote)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.itemfile, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.title.text = list.get(position).title
        holder.notes.text = list.get(position).note


    }

    override fun getItemCount(): Int {

        return list.size

    }
}