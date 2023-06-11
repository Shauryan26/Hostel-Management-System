package com.example.hostel_management

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hostel_management.REQUESTS.Adapter1
import com.example.hostel_management.REQUESTS.ViewModel1
import com.example.hostel_management.databinding.ActivityStudent1Binding

class STUDENT1 : AppCompatActivity() {

    private lateinit var binding: ActivityStudent1Binding

    lateinit var rec: RecyclerView
    private lateinit var viewModel: ViewModel1
    lateinit var movieAdapter: Adapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudent1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        movieAdapter= Adapter1()

        rec=findViewById(R.id.rv1)
        rec.apply{
            layoutManager= LinearLayoutManager(context)
            adapter=movieAdapter
        }
        Log.i("Tag","Bady")
        viewModel= ViewModelProvider(this)[ViewModel1::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMoviesData(movieList)
        })

    }


}