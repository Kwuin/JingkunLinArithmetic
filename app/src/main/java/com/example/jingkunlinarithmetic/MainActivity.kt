package com.example.jingkunlinarithmetic

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var operationSpinner: Spinner
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        number1EditText = findViewById(R.id.number1EditText)
        number2EditText = findViewById(R.id.number2EditText)
        operationSpinner = findViewById(R.id.operationSpinner)
        resultTextView = findViewById(R.id.resultTextView)
        val calculateButton: Button = findViewById(R.id.calculateButton)

        val operations = arrayOf("+", "-", "*", "/", "%")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, operations)
        operationSpinner.adapter = adapter

        calculateButton.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val num1 = number1EditText.text.toString().toFloatOrNull()
        val num2 = number2EditText.text.toString().toFloatOrNull()

        if (num1 != null && num2 != null) {
            val result = when (operationSpinner.selectedItem.toString()) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0f) num1 / num2 else "Cannot divide by zero"
                "%" -> if (num2 != 0f )num1 % num2 else num1
                else -> 0
            }
            resultTextView.text = "Result: $result"
        } else {
            resultTextView.text = "Please enter valid numbers"
        }
    }
}
