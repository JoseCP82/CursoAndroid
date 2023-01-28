package com.example.curso

import Data.DataDbHelper
import Model.Contact
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewContacts : RecyclerView
    private val contactAdapter : ContactAdapter = ContactAdapter()
    private var db: DataDbHelper?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about -> startActivity(Intent(this, AboutActivity::class.java))
            R.id.exit -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadData() {
        // Inicializa el Adaptador que almacenará y renderizará los datos del RecyclerView
        contactAdapter.ContactAdapter(getContacts(), this)

        // Inicializa el RecyclerView y le asocia el Adaptador con los datos
        recyclerViewContacts = findViewById(R.id.recyclerViewContacts) as RecyclerView
        recyclerViewContacts.setHasFixedSize(true)
        recyclerViewContacts.layoutManager = LinearLayoutManager(this)
        recyclerViewContacts.adapter = contactAdapter
    }

    fun nextView(view:View) {
        val next = Intent(this,FormActivity::class.java)
        startActivity(next)
    }

    fun getContacts(): ArrayList<Contact>{
        db=DataDbHelper(this)
        val contacts: ArrayList<Contact> = db!!.getAllContacts()
        return contacts
    }
}