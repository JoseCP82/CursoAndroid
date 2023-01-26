package com.example.curso

import Model.Contact
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewContacts : RecyclerView
    val contactAdapter : ContactAdapter = ContactAdapter()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    private fun getContacts(): MutableList<Contact>{
        val contacts:MutableList<Contact> = ArrayList()

        //Get all de la SQLlite

        return contacts
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    */
}