package com.example.hostel_management

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hostel_management.LoginApi.Response
import com.example.hostel_management.LoginApi.ReterofitClient1
import com.example.hostel_management.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {


    lateinit var emailId: EditText
    lateinit var password: EditText
    lateinit var login: Button

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var register1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        register1=findViewById(R.id.RegisterButton)
        register1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, Registration::class.java)
                startActivity(intent)
            }

    })
        login=findViewById(R.id.loginButton)
        emailId=findViewById(R.id.emailId)
        password=findViewById(R.id.Password)
        login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                var email1 = emailId.getText().toString()
                var password1 = password.getText().toString()
                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)) {
                    Toast.makeText(
                        applicationContext,
                        "Enter Email and Password both",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else{

                    ReterofitClient1.api.setProfile(email1,password1).enqueue(object :
                        Callback<Response> {
                        override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                            if(response.body()!=null) {
                                var l1:List<com.example.hostel_management.LoginApi.User>
                                l1=response.body()!!.users
                                Toast.makeText(applicationContext, "You are successfully Logged in!!!", Toast.LENGTH_SHORT).show()
                                if(l1[0].User=="ADMIN"){
                                val intent = Intent(applicationContext, STUDENT1::class.java)
                                    startActivity(intent)
                                }
                                else{
                                    val intent = Intent(applicationContext, Student_Home::class.java)
                                    startActivity(intent)

                                }


                            }
                            else{
                                Toast.makeText(applicationContext, "Sorry!! Wrong Credentials", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<Response>, t: Throwable) {
                            Log.i("Tag",t.message.toString())
                        }

                    })


                }
            }

        })



}
}