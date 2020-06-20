package com.hansandroid.simplenotes.presentation.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hansandroid.simplenotes.R
import com.hansandroid.simplenotes.domain.model.NoteModel
import javax.inject.Inject


class NoteAdapter (private val didTap: (noteId: Long) -> Unit) : RecyclerView.Adapter<NoteViewHolder>() {

    val notes = mutableListOf<NoteModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note, didTap)
    }

    fun updateNotes(notes: List<NoteModel>) {
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }

    fun onItemDelete(position: Int) : NoteModel {
        val noteModel = notes[position]
        notes.removeAt(position)
        notifyDataSetChanged()
        return noteModel
    }

}