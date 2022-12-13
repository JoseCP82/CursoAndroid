package com.example.curso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SecondView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_view)
    }

    fun backView(view: View) {
        val back = Intent(this,MainActivity::class.java)
        startActivity(back)
    }
}