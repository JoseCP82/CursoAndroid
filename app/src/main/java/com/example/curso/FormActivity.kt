package com.example.curso

import Data.DataDbHelper
import Model.Contact
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity() {

    lateinit var editName: EditText
    lateinit var editPhone: EditText

    private var db: DataDbHelper?=null
    private var list: MutableList<Contact> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_view)

        editName=findViewById(R.id.editName)
        editPhone=findViewById(R.id.editPhone)

        db= DataDbHelper(this )
    }

    fun addData() {
        list!!.add(Contact(editName.text.toString(), editPhone.text.toString()))
        db!!.insert(list)
        editName.setText("")
        editPhone.setText("")
    }

    fun backView(view: View) {
        try {
            addData()
            Toast.makeText(applicationContext,"Contact saved successfully!",Toast.LENGTH_SHORT).show()
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val back = Intent(this,MainActivity::class.java)
        finishActivity(0)
    }
}