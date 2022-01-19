package com.example.sandeep.app_sharing.Adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sandeep.app_sharing.R
import com.example.sandeep.app_sharing.imageloader.imageClass
import com.example.sandeep.app_sharing.imageloader.videoClass

class VideoAdaptor(val context: Context, private val videoList: ArrayList<videoClass>):RecyclerView.Adapter<VideoAdaptor.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
            val view=LayoutInflater.from(parent.context).inflate(R.layout.image_item,parent,false)
            return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val viewItem= videoList[position]
        //holder.image.setImageURI(Uri.parse(imgList[position]))
        Glide.with(context).load(viewItem.videoPath).apply(RequestOptions().centerCrop()).into(holder.image)

        holder.image.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,viewItem.videoPath.toString() , Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return videoList.size!!
    }

    class viewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val image:ImageView=item.findViewById(R.id.img)
    }

    interface photoListner {
        fun onPhotoclick(viewItem: String)
    }

}
