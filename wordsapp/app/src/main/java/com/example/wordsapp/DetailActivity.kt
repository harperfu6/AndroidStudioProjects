package com.example.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letterId = intent?.extras?.getString(LETTER).toString()
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordAdapter(letterId, this)
    }
}
