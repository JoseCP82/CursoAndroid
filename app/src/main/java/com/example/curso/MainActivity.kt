package com.example.curso

import Data.DataDbHelper
import Model.Person
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var editName: EditText
    lateinit var editAge: EditText

    private var db:DataDbHelper?=null
    private var list: MutableList<Person> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName=findViewById(R.id.editName)
        editAge=findViewById(R.id.editAge)

        db= DataDbHelper(this )

    }

    fun nextView(view:View) {
        val next = Intent(this,SecondView::class.java)
        startActivity(next)
    }

    fun addDatos(view: View) {
        list!!.add(Person(editName.text.toString(), editAge.text.toString()))
        db!!.insert(list)
        editName.setText("")
        editAge.setText("")
    }
}