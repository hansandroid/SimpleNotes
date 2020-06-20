package com.hansandroid.simplenotes.presentation.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hansandroid.simplenotes.R
import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.presentation.SimpleNotesApp
import com.hansandroid.simplenotes.presentation.presenter.NoteListPresenter
import com.hansandroid.simplenotes.presentation.view.SpacingItemDecorator
import com.hansandroid.simplenotes.presentation.view.activity.NotesActivity
import com.hansandroid.simplenotes.presentation.view.recyclerview.NoteAdapter
import kotlinx.android.synthetic.main.fragment_notes_list.*
import javax.inject.Inject

class NotesListFragment : Fragment(), NoteListPresenter.View {

    @Inject lateinit var mPresenter: NoteListPresenter
    private val TAG = NotesListFragment::class.simpleName

    private val didTap: (noteId: Long) -> Unit = {id ->
        (context as NotesActivity).replaceFragment(NoteDetailFragment.newInstance(id))
    }

    private val mNotesAdapter: NoteAdapter = NoteAdapter(didTap)

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
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val actionBar = (activity as? AppCompatActivity)?.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar?.title = context?.getString(R.string.app_name)

        btn_add_note.setOnClickListener { onFabClicked() }
        configureRecyclerView()

        loadNotes()
    }

    private fun loadNotes() {
        mPresenter.loadNotes()
    }

    private fun configureRecyclerView() {
        recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(SpacingItemDecorator(20))
            adapter = mNotesAdapter
        }
        val itemTouchCallback = ItemTouchCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    override fun onLoadNotesSuccess(notes: List<NoteModel>) {
        mNotesAdapter.updateNotes(notes)
    }

    override fun onLoadNotesError(throwable: Throwable) {
        Log.e(TAG, throwable.message ?: "Unknown error")
    }

    override fun onFabClicked() {
        (context as NotesActivity).replaceFragment(NoteDetailFragment())
    }

    override fun onDeleteNoteSuccess() {
        Log.d(TAG, "Delete note Success")
    }

    override fun onDeleteNoteError(throwable: Throwable) {
        Log.e(TAG, "")
    }

    inner class ItemTouchCallback(dragDirs: Int, swipeDirs: Int) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            mPresenter.deleteNote(mNotesAdapter.onItemDelete(position))
        }
    }

}