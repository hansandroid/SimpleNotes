package com.hansandroid.simplenotes.presentation.view.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.hansandroid.simplenotes.R
import com.hansandroid.simplenotes.presentation.view.fragment.NoteDetailFragment
import com.hansandroid.simplenotes.presentation.view.fragment.NotesListFragment

class NotesActivity : SingleFragmentActivity() {

    private val TAG = NotesActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
    }

    override fun createFragment(): Fragment {
        return NotesListFragment()
    }

    override fun replaceFragment(fragment: Fragment) {
        Log.d(TAG, "replaceFragment")
    }

}
