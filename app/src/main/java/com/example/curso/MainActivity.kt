package com.example.curso

import Data.DataDbHelper
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    private var db:DataDbHelper?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db=DataDbHelper(this )

        editText = findViewById(R.id.editText)

        editText.addTextChangedListener {
            text -> Log.d("",text.toString())
        }
    }

    fun nextView(view:View) {
        val next = Intent(this,SecondView::class.java)
        startActivity(next)
    }
}