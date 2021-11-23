package com.example.faircorp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView

const val WINDOW_NAME_PARAM = "com.faircorp.windowname.attribute"

class WindowActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_windows)
        val param = intent.getStringExtra(WINDOW_NAME_PARAM)
        val windowName = findViewById<TextView>(R.id.txt_window_name)
        windowName.text = param
    }


    fun returnWindow(view: View) {

        // Do something in response to button
        val intent = Intent(this, MainActivity::class.java).apply {
        }
        startActivity(intent)
    }


}