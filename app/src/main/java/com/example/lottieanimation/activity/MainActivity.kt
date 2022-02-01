package com.example.lottieanimation.activity


import android.content.Context
import android.os.Bundle
import android.telephony.TelephonyManager
import android.telephony.TelephonyManager.PHONE_TYPE_NONE
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lottieanimation.R
import com.example.lottieanimation.adapter.CustomAdapterPosts
import com.example.lottieanimation.helper.SpaceItemDecoration
import com.example.lottieanimation.modul.Users
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Objects.requireNonNull


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       initView()
       val member =  prapareMemberList()
        refreshAdapter(member)

    }
    fun initView(){

       val manager = applicationContext.getSystemService(Context.TELEPHONY_SERVICE)as TelephonyManager

        if (requireNonNull(manager).phoneType === PHONE_TYPE_NONE){
            recyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            val decoration = SpaceItemDecoration(10)
            recyclerView.addItemDecoration(decoration)
        }else{
            recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            val decoration = SpaceItemDecoration(10)
            recyclerView.addItemDecoration(decoration)

        }
     }
    fun refreshAdapter(users: List<Users>){
        val adapter = CustomAdapterPosts(users)
        recyclerView.adapter = adapter
    }
    fun prapareMemberList():List<Users>{
        val users = ArrayList<Users>()
        for (i in 0..15){

            users.add(Users())

        }
        return users
    }
}