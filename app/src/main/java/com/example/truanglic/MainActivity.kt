package com.example.truanglic

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.sqrt
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Находим элементы интерфейса
        val cathetusAInput = findViewById<EditText>(R.id.cathetusA)
        val cathetusBInput = findViewById<EditText>(R.id.cathetusB)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        // Устанавливаем слушатель на кнопку
        calculateButton.setOnClickListener {
            // Получаем значения катетов
            val cathetusA = cathetusAInput.text.toString().toDoubleOrNull()
            val cathetusB = cathetusBInput.text.toString().toDoubleOrNull()

            // Проверяем корректность ввода
            if (cathetusA == null || cathetusB == null) {
                Toast.makeText(this, "Введите корректные значения для обоих катетов", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Вычисляем гипотенузу
            val hypotenuse = sqrt(cathetusA * cathetusA + cathetusB * cathetusB)

            // Выводим результат через Toast
            Toast.makeText(this, "Гипотенуза: $hypotenuse", Toast.LENGTH_LONG).show()
        }
    }
}