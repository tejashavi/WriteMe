package com.jbhifitech.writeme.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jbhifitech.writeme.R


/**
 * A simple [Fragment] subclass.
 * Use the [SaveNotes.newInstance] factory method to
 * create an instance of this fragment.
 */
class SaveNotes : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save_notes, container, false)
    }


}