package com.jbhifitech.writeme.db

import androidx.room.*

@Dao
interface NoteDao {
    @Insert
    fun addNote(note : Note)
    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getallNotes() : List<Note>

    @Insert
    fun addMultipleNote(vararg note : Note)

    @Update
    fun updateNote(note :Note)

    @Delete
    fun deletenote(note : Note)

    @Delete
    fun deleteAllnote(note : List<Note>)
}