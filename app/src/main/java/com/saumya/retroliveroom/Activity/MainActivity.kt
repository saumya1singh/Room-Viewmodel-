package com.saumya.retroliveroom.Activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.saumya.retroliveroom.Model.DeveloperModel
import com.saumya.retroliveroom.DeveloperRecyclerViewAdapter
import com.saumya.retroliveroom.R


class MainActivity : AppCompatActivity() {

    lateinit var developerRecyclerView: RecyclerView
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        developerRecyclerView = findViewById(R.id.developerRecyclerView)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        if(isNetworkConnected(this))
        {
            mainActivityViewModel.getDeveloperFromAPIAndStore()

        }
        else
        {
            Toast.makeText(this,"No internet found. Showing cached list in the view",Toast.LENGTH_LONG).show()
        }

        mainActivityViewModel.getAllDeveloperList().observe(this, Observer<List<DeveloperModel>> {
        developerList ->
            Log.e(MainActivity::class.java.simpleName,developerList.toString())
            setUpRecyclerView(developerList!!)
        })
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    fun setUpRecyclerView(developers : List<DeveloperModel>)
    {
        val developerRecyclerViewAdapter = DeveloperRecyclerViewAdapter(this, developers)
        developerRecyclerView.adapter = developerRecyclerViewAdapter
        developerRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager
        .VERTICAL,false)
        developerRecyclerView.setHasFixedSize(true)
    }

}
