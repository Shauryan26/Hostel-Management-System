package com.example.hostel_management

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.hostel_management.RegisterAPI.ReterofitClient1
import com.example.hostel_management.databinding.ActivityRegistrationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Registration : AppCompatActivity() {
    lateinit var emailId: EditText
    lateinit var password: EditText
    lateinit var register: Button

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()


        register=findViewById(R.id.Submit)
        emailId=findViewById(R.id.emailId1)
        password=findViewById(R.id.password1)

        register.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                var email1 = emailId.getText().toString()
                var password1 = password.getText().toString()
                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)) {
                    Toast.makeText(
                        applicationContext,
                        "Enter Email and Password both",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {

                    ReterofitClient1.api.setProfile(email1,password1).enqueue(object :
                        Callback<com.example.hostel_management.RegisterAPI.Response> {
                        override fun onResponse(call: Call<com.example.hostel_management.RegisterAPI.Response>, response: Response<com.example.hostel_management.RegisterAPI.Response>) {
                            if(response.body()!=null) {

                                Toast.makeText(applicationContext, "You are successfully Registered!!!", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<com.example.hostel_management.RegisterAPI.Response>, t: Throwable) {
                            Log.i("Tag",t.message.toString())
                        }

                    })
                }
            }

        })

    }


}