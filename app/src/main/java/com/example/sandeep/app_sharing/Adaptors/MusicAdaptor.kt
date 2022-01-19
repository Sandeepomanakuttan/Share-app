package com.example.sandeep.app_sharing.Adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sandeep.app_sharing.R
import com.example.sandeep.app_sharing.imageloader.musicClass

class MusicAdaptor(val context: Context,val mlist:ArrayList<musicClass>):RecyclerView.Adapter<MusicAdaptor.viewHolder>() {
    class viewHolder(view: View) :RecyclerView.ViewHolder(view) {

        val musicName:TextView=view.findViewById(R.id.txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.music_model,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val music=mlist[position]
        holder.musicName.text=music.musicName
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}