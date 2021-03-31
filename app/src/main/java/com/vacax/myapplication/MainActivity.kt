package com.vacax.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {

    companion object{
        val dataScope = CoroutineScope(Dispatchers.IO)
    }

    val b:MutableList<User> = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
        ).build()



        dataScope.launch {
            val userDao = db.userDao()
            val users: List<User> = userDao.getAll()
//            println("slkdfjk昆仑山搭街坊卡拉技术的    ${users[0].firstName}")
        }

    }
}