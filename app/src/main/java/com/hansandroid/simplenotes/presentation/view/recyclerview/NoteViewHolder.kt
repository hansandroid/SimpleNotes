package com.hansandroid.simplenotes.presentation.view.recyclerview

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hansandroid.simplenotes.R
import com.hansandroid.simplenotes.domain.model.NoteModel

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mNoteTextView by lazy { itemView.findViewById(R.id.note_text) as TextView }
    private val mCardView by lazy { itemView.findViewById(R.id.card) as CardView }

    fun bind(noteModel: NoteModel, didTap: (noteId: Long) -> Unit) {
        mNoteTextView.text = noteModel.noteText
        mCardView.setOnClickListener { didTap(noteModel.id) }
    }

}