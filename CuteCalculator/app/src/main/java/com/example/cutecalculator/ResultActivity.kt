package com.example.cutecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Second screen to display result
class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connect to layout
        setContentView(R.layout.activity_result)

        // Get View references
        val txtResult = findViewById<TextView>(R.id.txtResult)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Receive result from MainActivity
        val result = intent.getIntExtra("RESULT", 0)

        // Display result
        txtResult.text = getString(R.string.result_display, result)

        // BACK button click
        btnBack.setOnClickListener {
            // This will close the current activity and go back to the previous one
            finish()
        }
    }
}