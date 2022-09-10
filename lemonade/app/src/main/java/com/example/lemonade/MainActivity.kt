package com.example.lemonade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val LEMONADE_STATE = "LEMONADE_STATE"
    private val LEMON_SIZE = "LEMON_SIZE"
    private val SQUEEZE_COUNT = "SQUEEZE_COUNT"

    // SELECT represents the "pick lemon" state
    private val SELECT = "select"
    // SQUEEZE represents the "squeeze lemon" state
    private val SQUEEZE = "squeeze"
    // DRINK represents the "drink lemonade" state
    private val DRINK = "drink"
    // RESTART represents the state where the lemonade has been drunk and the glass is empty
    private val RESTART = "restart"

    // Default the state to select
    private var lemonadeState = "select"
    // Default lemonSize to -1
    private var lemonSize = -1
    // Default the squeezeCount to -1
    private var squeezeCount = -1


    private var lemonImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lemonImage = findViewById(R.id.image_lemon_state)
        setViewElements()
        lemonImage!!.setOnClickListener {
            clickLemonImage()
        }
        lemonImage!!.setOnLongClickListener {
            showSnackBar()
        }

    }

    private fun clickLemonImage() {
        lemonadeState = when (lemonadeState) {
            SELECT -> {
                lemonSize = LemonTree().pick()
                squeezeCount = 0
                SQUEEZE
            }
            SQUEEZE -> {
                squeezeCount++
                lemonSize--
                if (lemonSize == 0) {
                    DRINK
                } else {
                    SQUEEZE
                }
            }
            DRINK -> {
                lemonSize = -1
                RESTART
            }
            RESTART -> {
                SELECT
            }
            else -> lemonadeState
        }

        setViewElements()
    }

    private fun setViewElements() {
        val textAction: TextView = findViewById(R.id.text_action)
        val text = when (lemonadeState) {
            SELECT -> {
                lemonImage!!.setImageResource(R.drawable.lemon_tree)
                lemonImage!!.contentDescription = lemonadeState

                "クリックしてレモンを選択してください。"
            }
            SQUEEZE -> {
                lemonImage!!.setImageResource(R.drawable.lemon_squeeze)
                lemonImage!!.contentDescription = lemonadeState

                "クリックしてレモンを絞ってください。"
            }
            DRINK -> {
                lemonImage!!.setImageResource(R.drawable.lemon_drink)
                lemonImage!!.contentDescription = lemonadeState

                "クリックしてレモネードを飲んでください。"
            }
            RESTART -> {
                lemonImage!!.setImageResource(R.drawable.lemon_restart)
                lemonImage!!.contentDescription = lemonadeState

                "クリックして最初からやり直してください。"
            }
            else -> "error!!"
        }
        textAction.setText(text)
    }

    private fun showSnackBar(): Boolean {
        if (lemonadeState != SQUEEZE) {
            return false
        }
        val squeezeText = getString(squeezeCount)
        Snackbar.make(
            findViewById(R.id.constraint_Layout),
            squeezeText,
            Snackbar.LENGTH_SHORT
        ).show()
        return true
    }
}

class LemonTree {
    // determines how many times a lemon needs to be squeezed.
    fun pick(): Int {
        return (2..4).random()
    }
}