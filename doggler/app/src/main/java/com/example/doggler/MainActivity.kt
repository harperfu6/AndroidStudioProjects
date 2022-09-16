package com.example.doggler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.doggler.adapter.DogCardAdapter
import com.example.doggler.data.DataResource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataset = DataResource.dogs

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = DogCardAdapter(dataset)
    }
}