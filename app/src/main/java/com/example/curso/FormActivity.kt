package com.example.curso

import Data.DataDbHelper
import Model.Contact
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class FormActivity : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editPhone: EditText
    private lateinit var editDate: EditText
    private var db:DataDbHelper?=null
    private lateinit var sp: Spinner

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_view)

        editName=findViewById(R.id.editName)
        editPhone=findViewById(R.id.editPhone)
        editDate=findViewById(R.id.editDate)
        editDate.setOnClickListener{ showDatePickerDialog() }

        val phoneTypes:  ArrayList<String> = ArrayList()
        phoneTypes.add("Home")
        phoneTypes.add("Cell")
        phoneTypes.add("Other")
        val adp: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, phoneTypes)
        sp = findViewById(R.id.spinnerPhoneType)
        sp.setAdapter(adp)
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day:Int, month:Int, year:Int){
        editDate.setText("$day/$month/$year")
    }

    private fun addData() {
        db= DataDbHelper(this)
        if(editName.text.isEmpty() || editPhone.text.isEmpty()) {
            Toast.makeText(this, "Please enter required fields.",Toast.LENGTH_SHORT).show()
        } else {
            val result = db!!.insertContact(Contact(editName.text.toString(), editPhone.text.toString(),
                                            editDate.text.toString(), sp.selectedItemId.toString()))
            if(result>-1){
                Toast.makeText(applicationContext, "Contact saved successfully.",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Contact no saved..",Toast.LENGTH_SHORT).show()
            }
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            finish()
        }
    }

    fun backView(view: View) {
        addData()
    }

    fun removeConctact(view: View, id: Int) {

        finish()
    }
}