package com.example.sandeep.app_sharing.Adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sandeep.app_sharing.R
import com.example.sandeep.app_sharing.imageloader.imageClass

class GalaryAdaptor(val context: Context, private val imgList: ArrayList<imageClass>,val listner:ClickListner):RecyclerView.Adapter<GalaryAdaptor.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
            val view=LayoutInflater.from(parent.context).inflate(R.layout.image_item,parent,false)
            return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val viewItem= imgList[position]
        //holder.image.setImageURI(Uri.parse(imgList[position]))
        Glide.with(context).load(viewItem.imagePath).apply(RequestOptions().centerCrop()).into(holder.image)

        holder.image.setOnClickListener(View.OnClickListener {

            if (!holder.select.isVisible){
                holder.select.visibility=View.VISIBLE
                listner.onclickPlus()
            }else{
                holder.select.visibility=View.INVISIBLE
                listner.onclickMinus()
            }
        })
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    class viewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val image:ImageView=item.findViewById(R.id.img)
        val select:ImageView=item.findViewById(R.id.select)
    }

    interface ClickListner {

        fun onclickPlus()

        fun onclickMinus()


    }



}
