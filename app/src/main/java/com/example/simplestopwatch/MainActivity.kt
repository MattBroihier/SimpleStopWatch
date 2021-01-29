package com.example.simplestopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var running = false
    private var seconds = 0

    fun onClickStart(view: View) {
        running = true
    }
    fun onClickStop(view: View) {
        running = false
    }

    fun onClickReset(view: View) {
        running = false
        seconds = 0
    }
}