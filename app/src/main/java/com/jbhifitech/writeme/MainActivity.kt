package com.jbhifitech.writeme

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jbhifitech.writeme.adapter.NoteAdapter
import com.jbhifitech.writeme.db.Note
import com.jbhifitech.writeme.db.NoteDatabase
import com.jbhifitech.writeme.fragment.AddNotes
import com.jbhifitech.writeme.fragment.SaveNotes
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_save_note.*

class MainActivity : AppCompatActivity() {

    private lateinit var list : List<Note>
    private lateinit var adapters : NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = ArrayList<Note>()

        getAllNotes(this)


        add.setOnClickListener {
            SaveNoteActivity.open(this)
        }

//        supportFragmentManager.beginTransaction().replace(R.id.root, AddNotes()).commit()

        
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.deleteall->{
                Toast.makeText(this,"this",Toast.LENGTH_SHORT).show()

                AlertDialog.Builder(this).apply {
                    setTitle("Delete All Notes")
                    setMessage("Are You Sure You Want To Delete ")
                    setPositiveButton("Yes"){_,_->
                        deleteAllNotes(this@MainActivity)

                    }
                    setNegativeButton("No"){
                        _,_->
                    }
                }.show()
            }

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true

    }

    private fun getAllNotes(context: Context) {
        class getNotesasync :AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg p0: Void?): Void? {

              list =   NoteDatabase(context).getNotes().getallNotes()

                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                adapters = NoteAdapter(context,list)

                rv.apply {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = adapters
                }
            }

        }


        getNotesasync().execute()
    }
    private fun deleteAllNotes(context: Context)
    {
        class deleteNotesasync :AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg p0: Void?): Void? {
                val allnote = NoteDatabase(context).getNotes().getallNotes()
                NoteDatabase(context).getNotes().deleteAllnote(allnote)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(context,"delete",Toast.LENGTH_SHORT).show()
             context.startActivity(Intent(context,this@MainActivity::class.java))
                finish()


            }

        }


        deleteNotesasync().execute()
    }
}