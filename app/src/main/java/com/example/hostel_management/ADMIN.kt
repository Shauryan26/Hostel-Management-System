package com.example.hostel_management

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.hostel_management.RoomRequestAPI.RegisterResponse
import com.example.hostel_management.RoomRequestAPI.ReterofitClient1
import com.example.hostel_management.databinding.ActivityAdminBinding
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ADMIN : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAdminBinding
    lateinit var submit: Button
    lateinit var Name: TextInputEditText
    lateinit var RegNo: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var non2: RadioButton
    lateinit var non3: RadioButton
    lateinit var non4: RadioButton
    lateinit var ac2: RadioButton
    lateinit var ac3: RadioButton
    lateinit var ac4: RadioButton
    lateinit var name1:String
    lateinit var RegNo1:String
    lateinit var email1:String
    lateinit var room:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        init()

        submit.setOnClickListener {
            name1= Name.text?.trim().toString()
            RegNo1= RegNo.text?.trim().toString()
            email1= email.text?.trim().toString()

            if(non2.isChecked){ room="2na"}
            else if(non3.isChecked){room="3na"}
            else if(non4.isChecked){room="4na"}
            else if(ac2.isChecked){room="2a"}
            else if(ac3.isChecked){room="3a"}
            else{room="4a"}
            val sharedpref=getSharedPreferences("myPref", MODE_PRIVATE)
            val editor=sharedpref.edit()
            editor.apply{
                putString("EmailID", email1)
                apply()
            }
            ReterofitClient1.api.setProfile(name1,RegNo1,email1,room).enqueue(object :
                Callback<RegisterResponse> {
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
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
    fun init(){
        Name=findViewById(R.id.name)
        RegNo=findViewById(R.id.Reg)
        email=findViewById(R.id.emailr)
        non2=findViewById(R.id.radio2n)
        non3=findViewById(R.id.radio3n)
        non4=findViewById(R.id.radio4n)
        ac2=findViewById(R.id.radio2a)
        ac3=findViewById(R.id.radio3a)
        ac4=findViewById(R.id.radio4a)
        submit=findViewById(R.id.loginButton)
    }

}