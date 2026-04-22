package com.example.cutecalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Main screen of the calculator
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connect this activity to the XML layout
        setContentView(R.layout.activity_main)

        // Get references to input fields
        val number1 = findViewById<EditText>(R.id.editNumber1)
        val number2 = findViewById<EditText>(R.id.editNumber2)

        // Get references to buttons
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnGoToResult = findViewById<Button>(R.id.btnGoToResult)

        // ADD button click
        btnAdd.setOnClickListener {
            calculate(number1, number2, "+")
        }

        // SUBTRACT button click
        btnSubtract.setOnClickListener {
            calculate(number1, number2, "-")
        }

        // MULTIPLY button click
        btnMultiply.setOnClickListener {
            calculate(number1, number2, "*")
        }

        // DIVIDE button click
        btnDivide.setOnClickListener {
            calculate(number1, number2, "/")
        }

        // CLEAR button click
        btnClear.setOnClickListener {

            // Clear both input boxes
            number1.text.clear()
            number2.text.clear()

            // Show message to user
            Toast.makeText(this, "Cleared 💗", Toast.LENGTH_SHORT).show()

            // Debug log
            Log.d("CALCULATOR", "Inputs cleared")
        }

        // GO TO RESULT button click
        btnGoToResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }
    }

    // Function to perform calculations
    private fun calculate(num1Field: EditText, num2Field: EditText, operator: String) {

        try {
            // Convert text input to integers
            val num1 = num1Field.text.toString().toInt()
            val num2 = num2Field.text.toString().toInt()

            var result = 0

            // Determine operation
            when (operator) {
                "+" -> result = num1 + num2
                "-" -> result = num1 - num2
                "*" -> result = num1 * num2
                "/" -> {
                    // Prevent divide by zero crash
                    if (num2 == 0) {
                        Toast.makeText(this, "Cannot divide by zero 💗", Toast.LENGTH_SHORT).show()
                        return
                    }
                    result = num1 / num2
                }
            }

            // Log result for debugging
            Log.d("CALCULATOR", "Result = $result")

            // Send result to next screen
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)

        } catch (e: Exception) {

            // Handle invalid input
            Toast.makeText(this, "Please enter valid numbers 💗", Toast.LENGTH_SHORT).show()
            Log.e("ERROR", "Invalid input", e)
        }
    }
}