package com.example.business_app_design.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.business_app_design.R
import com.example.business_app_design.model.FlowsDataModel

class FlowsRcvAdapter(private val data: List<FlowsDataModel>): RecyclerView.Adapter<FlowsRcvAdapter.FlowsRcvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowsRcvViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_flow_item, parent, false)
        return FlowsRcvViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlowsRcvViewHolder, position: Int) {
        holder.titleTextView.setText(data.get(position).titleText)
        holder.timeTextView.setText(data.get(position).time)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    class FlowsRcvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById<TextView>(R.id.flowsTitleTv)
        val timeTextView: TextView = itemView.findViewById<TextView>(R.id.timeTextView)
        val icon: ImageView = itemView.findViewById<ImageView>(R.id.flowsIcon)
    }

}