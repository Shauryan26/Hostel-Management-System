package com.example.hostel_management

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.hostel_management.RequestStatus.Status
import com.example.hostel_management.RequestStatus.ReterofitClient1
import com.example.hostel_management.RequestStatus.User
import com.example.hostel_management.databinding.ActivityStudent1Binding
import com.example.hostel_management.databinding.ActivityViewRequestStatusBinding
import retrofit2.Call
import retrofit2.Callback

class ViewRequestStatus : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityViewRequestStatusBinding
    lateinit var t1:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewRequestStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        val sharedpref=getSharedPreferences("myPref", MODE_PRIVATE)
        var s1=sharedpref.getString("EmailID",null).toString()

        ReterofitClient1.api.setProfile(s1).enqueue(object :
            Callback<Status> {
            override fun onResponse(call: Call<Status>, response: retrofit2.Response<Status>) {
                    var l1:List<User>
                    l1=response.body()!!.users
                    t1=findViewById(R.id.t1)
                    t1.setText("Your Room No is"+l1[0].RoomNo)

            }

            override fun onFailure(call: Call<Status>, t: Throwable) {
                Log.i("Tag",t.message.toString())
            }

        })




    }


}