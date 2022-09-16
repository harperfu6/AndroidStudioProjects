package com.example.doggler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.doggler.adapter.DogCardAdapter
import com.example.doggler.const.Layout
import com.example.doggler.data.DataResource
import com.example.doggler.databinding.ActivityHorizontalListBinding

class HorizontalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHorizontalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup view binding
        binding = ActivityHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataset = DataResource.dogs
        val recyclerView = findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        recyclerView.adapter = DogCardAdapter(dataset, Layout.HORIZONTAL)
    }
}
