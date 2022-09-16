package com.example.doggler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doggler.R
import com.example.doggler.model.Dog

class DogCardAdapter(
    private val dataset: List<Dog>
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    class DogCardViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.dog_image)
        val dogNameTextView: TextView = view.findViewById(R.id.dog_name)
        val dogAgeTextView: TextView = view.findViewById(R.id.dog_age)
        val dogHobbiesTextView: TextView = view.findViewById(R.id.dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        return DogCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.dogNameTextView.text = item.name
        holder.dogAgeTextView.text = "Age: ${item.age}"
        holder.dogHobbiesTextView.text = "Hobbies: ${item.hobbies}"
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}