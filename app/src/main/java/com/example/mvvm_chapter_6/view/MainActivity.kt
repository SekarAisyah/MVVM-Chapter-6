package com.example.mvvm_chapter_6.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_chapter_6.databinding.ActivityMainBinding
import com.example.mvvm_chapter_6.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataUser()

    }

    fun showDataUser(){
        val viewModelUser = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModelUser.callUser()
        viewModelUser.liveDataUser.observe(this, {
            if (it!=null){
                binding.rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvUser.adapter = UserAdapter(it)

            }
        })
    }
}