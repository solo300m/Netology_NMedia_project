package ru.netology.nmedia

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(getString(R.string.unboard))
        Log.d("MainActivity", "onCreate: ${getString(R.string.unboard)}")
        Log.d("MainActivity", "onCreate: ${resources.displayMetrics.heightPixels}")
        Log.d("MainActivity", "onCreate: ${resources.displayMetrics.widthPixels}")
    }
}
