package com.example.doggler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doggler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalBtn.setOnClickListener { launchVertical() }
        binding.horizontalBtn.setOnClickListener { launchHorizontal() }
        binding.gridBtn.setOnClickListener { launchGrid() }

    }

    private fun launchVertical() {
        listIntent = Intent(this, VerticalListActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchHorizontal() {
        listIntent = Intent(this, HorizontalListActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchGrid() {
        listIntent = Intent(this, GridListActivity::class.java)
        startActivity(listIntent)
    }
}