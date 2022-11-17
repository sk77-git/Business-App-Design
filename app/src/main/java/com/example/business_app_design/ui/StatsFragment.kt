package com.example.business_app_design.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.business_app_design.R


class StatsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View= inflater.inflate(R.layout.fragment_stats, container, false)
        /*val toolbar: androidx.appcompat.widget.Toolbar= view.findViewById(R.id.statsToolbar)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
        setHasOptionsMenu(true)*/

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_menu, menu)
    }

}