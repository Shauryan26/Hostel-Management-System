package com.example.hostel_management

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.hostel_management.databinding.ActivityStudentHomeBinding

class Student_Home : AppCompatActivity() {

    private lateinit var binding: ActivityStudentHomeBinding

    lateinit var request: Button
    lateinit var view: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        request=findViewById(R.id.submit)
        view=findViewById(R.id.view)
        request.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, ADMIN::class.java)
                startActivity(intent)}


    })
        view.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, ViewRequestStatus::class.java)
                startActivity(intent)}


        })


}}