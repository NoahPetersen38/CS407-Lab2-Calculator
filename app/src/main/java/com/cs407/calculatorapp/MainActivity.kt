package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstInput = findViewById<EditText>(R.id.firstNumber)
        val secondInput = findViewById<EditText>(R.id.secondNumber)
        val addButton = findViewById<Button>(R.id.addButton)
        val subButton = findViewById<Button>(R.id.subButton)
        val multButton = findViewById<Button>(R.id.multButton)
        val divButton = findViewById<Button>(R.id.divButton)

        addButton.setOnClickListener {
            try {
                val firstNumber = firstInput.text.toString().toInt()
                val secondNumber = secondInput.text.toString().toInt()

                val addFinal = firstNumber + secondNumber

                val intent = Intent(this, CalcOutput::class.java)
                intent.putExtra("OUTPUT", addFinal.toString())
                startActivity(intent)
            } catch (e: NumberFormatException) {
                Toast.makeText(
                    this,
                    "Something went wrong, make sure both inputs are whole numbers",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        subButton.setOnClickListener {
            try {
                val firstNumber = firstInput.text.toString().toInt()
                val secondNumber = secondInput.text.toString().toInt()

                val addFinal = firstNumber - secondNumber

                val intent = Intent(this, CalcOutput::class.java)
                intent.putExtra("OUTPUT", addFinal.toString())
                startActivity(intent)
            } catch (e: NumberFormatException) {
                Toast.makeText(
                    this,
                    "Something went wrong, make sure both inputs are whole numbers",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        multButton.setOnClickListener {
            try {
                val firstNumber = firstInput.text.toString().toInt()
                val secondNumber = secondInput.text.toString().toInt()

                val addFinal = firstNumber * secondNumber

                val intent = Intent(this, CalcOutput::class.java)
                intent.putExtra("OUTPUT", addFinal.toString())
                startActivity(intent)
            } catch (e: NumberFormatException) {
                Toast.makeText(
                    this,
                    "Something went wrong, make sure both inputs are whole numbers",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        divButton.setOnClickListener {
            try {
                val firstNumber = firstInput.text.toString().toInt()
                val secondNumber = secondInput.text.toString().toInt()

                val addFinal = firstNumber / secondNumber

                val intent = Intent(this, CalcOutput::class.java)
                intent.putExtra("OUTPUT", addFinal.toString())
                startActivity(intent)
            } catch (e: NumberFormatException) {
                Toast.makeText(
                    this,
                    "Something went wrong, make sure both inputs are whole numbers",
                    Toast.LENGTH_SHORT
                ).show()
            } catch (e: ArithmeticException) {
                Toast.makeText(
                    this,
                    "Cannot divide by 0",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}