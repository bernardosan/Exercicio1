package com.example.exercicio1.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.alpha
import androidx.recyclerview.widget.RecyclerView
import com.example.exercicio1.R
import com.example.exercicio1.databinding.RvItemBinding
import com.example.exercicio1.models.User

class MainAdapter(val list: List<User>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder (val itemBinding: RvItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(user: User){
            itemBinding.tvName.text = user.name
            itemBinding.tvNumber.text = user.count.toString()
            itemBinding.tvGender.text = user.gender
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = list[position]
        holder.itemBinding.cvItem.setBackgroundColor(if(user.gender == "female") Color.WHITE else Color.parseColor("#CFCFCF"))
        holder.bindItem(user)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}