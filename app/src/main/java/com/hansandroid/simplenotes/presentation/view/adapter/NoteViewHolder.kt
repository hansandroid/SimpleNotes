package com.hansandroid.simplenotes.presentation.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hansandroid.simplenotes.R
import com.hansandroid.simplenotes.domain.model.NoteModel

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mTitleTextView by lazy { itemView.findViewById(R.id.note_title) as TextView }

    fun bind(noteModel: NoteModel) {
        mTitleTextView.text = noteModel.noteText
    }

}