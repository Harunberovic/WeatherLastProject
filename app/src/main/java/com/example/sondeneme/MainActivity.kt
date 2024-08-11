package com.example.sondeneme

import android.os.Bundle
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = arrayListOf()

        foodList.add(Food(R.drawable.ic_sunny, "Güneşli°","26°","İstanbul","14° - 27°"))
        foodList.add(Food(R.drawable.ic_sunny, "Güneşli°","26°","Ankara","14° - 27°"))
        foodList.add(Food(R.drawable.ic_sunny, "Güneşli°","26°","Erzurum","14° - 27°"))


        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter


        foodAdapter.onItemClick = { food ->
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("food", food)
            startActivity(intent)
        }
    }
}