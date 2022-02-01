package com.example.lottieanimation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.lottieanimation.R
import com.example.lottieanimation.modul.Users

class CustomAdapterPosts(val users:List<Users>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_menu_item,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is CustomViewHolder) {

            holder.apply {
                when {
                      position % 11 == 0 ->{
                          image_item.setImageResource(R.drawable.img_1)
                      }position % 3 == 0 ->{
                          image_item.setImageResource(R.drawable.img_2)
                      }position % 5 == 0 ->{
                          image_item.setImageResource(R.drawable.img)
                      }position % 7 == 0 ->{
                          image_item.setImageResource(R.drawable.img)
                     }
                }
            }
        }
    }

    override fun getItemCount(): Int {
       return users.size
    }
   class CustomViewHolder(view: View):RecyclerView.ViewHolder(view){
       val image_item = view.findViewById<ImageView>(R.id.im_item)
   }
}