package com.example.mvvm_chapter_6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_chapter_6.model.ResponseDataUserItem
import com.example.mvvm_chapter_6.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    lateinit var liveDataUser:MutableLiveData<List<ResponseDataUserItem>>

    init {
        liveDataUser = MutableLiveData()
    }

    fun getLiveDataUser() {

    }

    fun callUser() {
        ApiService.instance.getAllUser().enqueue(object : Callback<List<ResponseDataUserItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataUserItem>>,
                response: Response<List<ResponseDataUserItem>>
            ) {
                if (response.isSuccessful) {
                    liveDataUser.postValue(response.body())
                } else {
                    liveDataUser.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ResponseDataUserItem>>, t: Throwable) {
                liveDataUser.postValue(null)
            }

        })
    }

}
