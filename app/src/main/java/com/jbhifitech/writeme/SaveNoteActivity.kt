package com.jbhifitech.writeme

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jbhifitech.writeme.db.Note
import com.jbhifitech.writeme.db.NoteDatabase
import kotlinx.android.synthetic.main.activity_save_note.*
import kotlinx.android.synthetic.main.fragment_save_notes.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SaveNoteActivity : AppCompatActivity(),CoroutineScope {
    private lateinit var job : Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    companion object{
        fun open(activity : Activity){
            val intent = Intent(activity,SaveNoteActivity::class.java)
            activity.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_note)
        job = Job()

        savenote.setOnClickListener {

            val title = titlesave.text.toString().trim()
            val note = notesave.text.toString().trim()

            if(title.isEmpty()){
                titlesave.error = "Title required"
                titlesave.requestFocus()
                return@setOnClickListener
            }
            if(note.isEmpty()){
                notesave.error = "Note required"
                notesave.requestFocus()
                return@setOnClickListener
            }
            val roomnote = Note(title,note)
                        notefun(this,roomnote)

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

//coroutine
/*            launch {
                val roomnote = Note(title,note)

                applicationContext?.let {
                    NoteDatabase(it).getNotes().addNote(roomnote)
                    Toast.makeText(it,"notesaved",Toast.LENGTH_SHORT).show()
                }
            }*/


        }
        backbtn.setOnClickListener {
            onBackPressed()
        }
    }

    private fun notefun(context: Context,note : Note){
        class noteinbackground: AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg p0: Void?): Void ?{

                NoteDatabase(context).getNotes().addNote(note)

                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(context,"done",Toast.LENGTH_SHORT).show()
            }

        }
        noteinbackground().execute();
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}