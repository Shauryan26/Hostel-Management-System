package com.example.hostel_management.REQUESTS

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hostel_management.DeleteApi.Response
import com.example.hostel_management.DeleteApi.ReterofitClient1
import com.example.hostel_management.R
import com.example.hostel_management.RoomAllotmentAPI.RegisterResponse
import retrofit2.Call
import retrofit2.Callback

class Adapter1: RecyclerView.Adapter<Adapter1.ViewHolder>() {
    private var movieList=ArrayList<User>()

    fun setMoviesData(movieList : List<User>){
        this.movieList=movieList as ArrayList<User> /* = java.util.ArrayList<com.Result> */
        notifyDataSetChanged()
    }

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.name)
        val regNo = view.findViewById<TextView>(R.id.regNo)
        val id= view.findViewById<TextView>(R.id.id)
        val room = view.findViewById<TextView>(R.id.room)
        val accept=view.findViewById<Button>(R.id.acceptButton)
        val roomNo = view.findViewById<TextView>(R.id.roomNo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text=movieList[position].name
        holder.regNo.text=movieList[position].RegNo
        holder.id.text=movieList[position].email
        holder.room.text=movieList[position].room
        holder.accept.setOnClickListener {
                 holder.accept.text="ACCEPTED"

                ReterofitClient1.api.setProfile(movieList[position].email,movieList[position].RegNo).enqueue(object :
                Callback<Response> {
                override fun onResponse(call: Call<com.example.hostel_management.DeleteApi.Response>, response: retrofit2.Response<com.example.hostel_management.DeleteApi.Response>) {

                }

                override fun onFailure(call: Call<com.example.hostel_management.DeleteApi.Response>, t: Throwable) {
                    Log.i("Tag",t.message.toString())
                }

            })
            com.example.hostel_management.RoomAllotmentAPI.ReterofitClient1.api.setProfile(movieList[position].name,movieList[position].RegNo,movieList[position].email,holder.roomNo.getText().toString()).enqueue(object :
                Callback<RegisterResponse> {
                override fun onResponse(call: Call<RegisterResponse>, response: retrofit2.Response<RegisterResponse>) {
                    if(response.body()!=null) {

                        Log.i("NumberGenerated",response.body()!!.message);
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.i("Tag",t.message.toString())
                }

            })

        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}


