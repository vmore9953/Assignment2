package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myTextView: TextView
    private lateinit var textContainer: RelativeLayout

    private var isTextChanged = false
    private var isHeightChanged = false
    private var isTextColorYellow = false  // Track color toggle state
    private var textPosition = TextPosition.CENTER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Views
        myTextView = findViewById(R.id.myTextView)
        textContainer = findViewById(R.id.textContainer)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)


        // Button 1 - Toggle Text
        button1.setOnClickListener {
            myTextView.text = if (isTextChanged) "Hello" else "I am Abhi"
            isTextChanged = !isTextChanged
        }

        // Button 2 - Toggle Text Size
        button2.setOnClickListener {
            myTextView.textSize = if (isHeightChanged) 18f else 24f
            isHeightChanged = !isHeightChanged
        }

        // Button 3 - Center Text
        button3.setOnClickListener {
            textPosition = TextPosition.CENTER
            updateTextPosition()
        }

        // Button 4 - Move Text Up
        button4.setOnClickListener {
            textPosition = TextPosition.UP
            updateTextPosition()
        }

        // Button 5 - Move Text Down
        button5.setOnClickListener {
            textPosition = TextPosition.DOWN
            updateTextPosition()
        }

        // Button 6 - Toggle Text Color (Yellow/White)
        button6.setOnClickListener {
            toggleTextColor()
        }

    }

    // Function to update the position of the text based on selected position
    private fun updateTextPosition() {
        val params = myTextView.layoutParams as RelativeLayout.LayoutParams

        // Remove existing position rules
        params.removeRule(RelativeLayout.ALIGN_PARENT_TOP)
        params.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        params.removeRule(RelativeLayout.CENTER_IN_PARENT)

        when (textPosition) {
            TextPosition.CENTER -> params.addRule(RelativeLayout.CENTER_IN_PARENT)
            TextPosition.UP -> params.addRule(RelativeLayout.ALIGN_PARENT_TOP)
            TextPosition.DOWN -> params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        }

        myTextView.layoutParams = params
    }

    // Function to toggle text color between yellow and white
    private fun toggleTextColor() {
        if (isTextColorYellow) {
            myTextView.setTextColor(resources.getColor(android.R.color.white))
        } else {
            myTextView.setTextColor(resources.getColor(android.R.color.holo_orange_light))
        }
        isTextColorYellow = !isTextColorYellow
    }

    // Function to navigate to the next activity


    // Enum to represent text position states
    private enum class TextPosition {
        CENTER, UP, DOWN
    }
}
