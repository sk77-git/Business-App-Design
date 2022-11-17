package com.example.business_app_design.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.business_app_design.R


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        val getStartedButton: LinearLayout = view.findViewById(R.id.getStartedLayout)
        getStartedButton.setOnClickListener {
            //findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
        }
        return view
    }
}