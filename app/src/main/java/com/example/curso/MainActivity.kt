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
import java.text.FieldPosition

class MainActivity : AppCompatActivity(), OnContactClickListener {

    private lateinit var recyclerViewContacts : RecyclerView
    private var contactAdapter : ContactAdapter = ContactAdapter(this)
    private var db: DataDbHelper?=null
    private lateinit var contacts:ArrayList<Contact>

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
            R.id.exit -> System.exit(0)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContactItemClicked(position: Int) {
        val intent = Intent(this, FormActivity::class.java)
        intent.putExtra("idContact", contacts[position].getId())
        startActivity(intent)
    }

    private fun loadData() {
        // Inicializa el Adaptador que almacenará y renderizará los datos del RecyclerView
        contacts=getContacts()
        contactAdapter.ContactAdapter(contacts, this)

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