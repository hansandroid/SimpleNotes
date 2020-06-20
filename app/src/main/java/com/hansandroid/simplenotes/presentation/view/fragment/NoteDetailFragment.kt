package com.hansandroid.simplenotes.presentation.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hansandroid.simplenotes.R
import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.presentation.SimpleNotesApp
import com.hansandroid.simplenotes.presentation.presenter.NoteDetailPresenter
import kotlinx.android.synthetic.main.fragment_note_detail.*
import javax.inject.Inject

class NoteDetailFragment : Fragment(), NoteDetailPresenter.View {

    @Inject lateinit var mPresenter: NoteDetailPresenter
    private val TAG = NoteDetailFragment::class.simpleName
    private var mNoteModel: NoteModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as SimpleNotesApp).mComponent.inject(this)
        mPresenter.attachView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val actionBar = (activity as? AppCompatActivity)?.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val noteId = arguments?.getLong(ID_KEY)
        if (noteId != null) {
            mPresenter.loadNote(noteId)
        }

    }

    override fun onPause() {
        super.onPause()
        if (mNoteModel != null) {
            mPresenter.editNote(mNoteModel!!.id, note_text.text.toString())
        } else {
            mPresenter.addNote(note_text.text.toString())
        }
    }

    override fun onAddNoteSuccess() {
        Log.d(TAG, "Add note success...")
    }

    override fun onLoadNoteSuccess(note: NoteModel) {
        mNoteModel = note
        note_text.setText(note.noteText)
    }

    override fun onEditNoteSuccess() {
        Log.d(TAG, "Edit note success...")
    }

    override fun onNoteValidationFailed() {
        Log.e(TAG, "Note validation failed...")
    }

    override fun onAddNoteError(throwable: Throwable) {
        Log.e(TAG, "Add note error: ${throwable.message}")
    }

    override fun onEditNoteError(throwable: Throwable) {
        Log.e(TAG, "Edit note error: ${throwable.message}")
    }

    override fun onNoteLookupError(throwable: Throwable) {
        Log.e(TAG, "On note lookup error: ${throwable.message}")
    }

    companion object {
        private val ID_KEY = "id_key"

        @JvmStatic
        fun newInstance(noteId: Long): NoteDetailFragment {
            val fragment = NoteDetailFragment()
            val args = Bundle()
            args.putLong(ID_KEY, noteId)
            fragment.arguments = args
            return fragment
        }
    }

}