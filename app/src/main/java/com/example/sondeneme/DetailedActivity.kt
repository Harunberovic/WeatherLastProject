package com.example.sondeneme

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.ImageView

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val food = intent.getParcelableExtra<Food>("food")
        if (food != null) {
            val textView: TextView = findViewById(R.id.textView2)
            val imageView: ImageView = findViewById(R.id.imageView2)
            val derece: TextView = findViewById(R.id.textView4)
            val sehir: TextView = findViewById(R.id.sehirAdi)
            val tahminiSıcaklık: TextView = findViewById(R.id.textView11)

            textView.text = food.name
            imageView.setImageResource(food.image)
            sehir.text = food.temperature
            tahminiSıcaklık.text = food.tahminiSıcaklık
            sehir.text = food.city

        }

    }
 }