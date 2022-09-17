package com.example.wordsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter: RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val list = ('A').rangeTo('Z').toList()

    class LetterViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return LetterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text = item.toString()
        holder.button.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}