package com.example.business_app_design.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.business_app_design.R
import com.example.business_app_design.adapters.FlowsRcvAdapter
import com.example.business_app_design.model.FlowsDataModel


class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerview = view.findViewById<RecyclerView>(R.id.flowsRecyclerview)
        recyclerview.layoutManager = LinearLayoutManager(context)
        val data = ArrayList<FlowsDataModel>()
        for (i in 1..10) {
            data.add(FlowsDataModel(R.drawable.ic_baseline_add_circle_24,"Document verification","3 min ago"))
        }
        val adapter = FlowsRcvAdapter(data)
        recyclerview.adapter = adapter
        return view
    }

}