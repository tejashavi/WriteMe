package com.jbhifitech.writeme.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jbhifitech.writeme.R
import kotlinx.android.synthetic.main.fragment_add_notes.*
import kotlinx.android.synthetic.main.fragment_add_notes.view.*


class AddNotes : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_notes, container, false)


        return view


    }


}