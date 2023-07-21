package com.example.my

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.EditText
import android.widget.TextView
import android.content.Context
import android.content.SharedPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val label = findViewById<TextView>(R.id.main_label)
        val userData: EditText = findViewById(R.id.userData)
        val imageButton = findViewById<ImageButton>(R.id.img)
        imageButton.setOnClickListener {
            userData.text.clear()
        }

        sharedPreferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        editText = findViewById(R.id.userData)

        // Восстановление текста при запуске приложения
        editText.setText(sharedPreferences.getString("text", ""))
    }

    override fun onPause() {
        super.onPause()

        // Сохранение текста при выходе из приложения
        val textToSave = editText.text.toString()
        sharedPreferences.edit().putString("text", textToSave).apply()
    }
}





