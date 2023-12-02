package com.example.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Model.AddCampModel
import com.example.myapplication.R

class DonationClassAdapter(var mList: List<AddCampModel>) :
    RecyclerView.Adapter<DonationClassAdapter.ViewHolder>() {

    private var mListener: OnItemClickListener? = null

    // Setting up onClick listener interface
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val campLocation: TextView = itemView.findViewById(R.id.textView19)
        val date: TextView = itemView.findViewById(R.id.textView20)
        val orgName: TextView = itemView.findViewById(R.id.textView21)
        init {
            itemView.setOnClickListener {
                mListener?.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.blood_donation_campshelp_to_recycle_view,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DonationClassAdapter.ViewHolder, position: Int) {
        val currentCampLocation = mList[position]
        holder.campLocation.text = currentCampLocation.venue
        holder.date.text = currentCampLocation.heldOn
        holder.orgName.text = currentCampLocation.orgName
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}
