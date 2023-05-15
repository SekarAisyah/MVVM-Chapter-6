package com.example.mvvm_chapter_6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_chapter_6.databinding.ItemUserBinding
import com.example.mvvm_chapter_6.model.ResponseDataUserItem

class UserAdapter(var listUser: List<ResponseDataUserItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.titleUser.text = listUser[position].name
        holder.binding.umurUser.text = listUser[position].age.toString()
        holder.binding.alamatUser.text = listUser[position].address

    }
    override fun getItemCount(): Int {
        return listUser.size
    }

}