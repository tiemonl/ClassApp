package com.kroger.classapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CharacterDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_character_detail,
            container,
            false
        )

        if(arguments != null) {
            val name = requireArguments().getString("name")
            view.findViewById<TextView>(R.id.character_name_detail).text = name
        }
        return view
    }

}