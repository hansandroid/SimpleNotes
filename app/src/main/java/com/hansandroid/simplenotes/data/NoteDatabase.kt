package com.hansandroid.simplenotes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

fun createNoteDao(context: Context): NoteDao {
    return Room.databaseBuilder(context, NoteDatabase::class.java, "notesdb")
        .build().noteDao()
}

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}