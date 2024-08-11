package com.example.sondeneme

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    var onItemClick: ((Food) -> Unit)? = null

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val city: TextView = itemView.findViewById(R.id.sehir)
        val tahminiSıcaklık: TextView = itemView.findViewById(R.id.tahminiSıcaklık)
        val temperature: TextView = itemView.findViewById(R.id.derece)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.imageView.setImageResource(food.image)
        holder.textView.text = food.name
        holder.temperature.text= food.temperature
        holder.city.text = food.city
        holder.tahminiSıcaklık.text = food.tahminiSıcaklık

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(food)
        }
    }
}
