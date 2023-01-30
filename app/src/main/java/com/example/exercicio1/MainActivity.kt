package com.example.exercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercicio1.adapters.MainAdapter
import com.example.exercicio1.databinding.ActivityMainBinding
import com.example.exercicio1.models.User
import com.example.exercicio1.utils.lista_entrada.list
import java.util.*
import kotlin.collections.ArrayList

var binding: ActivityMainBinding? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        val userList= ArrayList<User>()

        list.forEach {
            val userName = it.removeRange(it.length-2,it.length)
            val userGender = if (it.removeRange(0,it.length-1).lowercase(Locale.getDefault()) == "f") "female" else "male"
            val count = countUserName(userName, list)
            userList.add(User(userName, count, userGender))
        }

        val sortedUserList = userList.sortedBy { it.name }

        val adapter = MainAdapter(sortedUserList)
        binding?.rvItems?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding?.rvItems?.adapter = adapter

    }

    private fun countUserName(name: String, list: List<String>): Int {
        val userNameList = ArrayList<String>()
        var count = 0

        list.forEach {
            val userName = it.removeRange(it.length-2,it.length)
            userNameList.add(userName)
        }

        count = userNameList.filter{it == name}.size

        return count
    }
}