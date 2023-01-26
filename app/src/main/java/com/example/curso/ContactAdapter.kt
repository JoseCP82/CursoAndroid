package com.example.curso

import Model.Contact
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    var contacts: MutableList<Contact>  = ArrayList()
    lateinit var context: Context
    lateinit var listener: View.OnClickListener;

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName = view.findViewById(R.id.nameTextView) as TextView
        val contactPhone = view.findViewById(R.id.phoneTextView) as TextView

        fun bind(contact: Contact, context: Context){
            contactName.text = contact.getName()
            contactPhone.text = contact.getPhone()
            // @TODO: mejorar el listener
            // https://medium.com/@amsavarthan/the-modern-approach-to-handle-item-click-on-recyclerview-6292cca3178d
            itemView.setOnClickListener(View.OnClickListener {
                Toast.makeText(context, contact.getName(), Toast.LENGTH_SHORT).show()
            })
        }
    }

    // Contruye el objeto adaptador recibiendo la lista de datos
    fun ContactAdapter(contacts : MutableList<Contact>, context: Context){
        this.contacts = contacts
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(layoutInflater.inflate(R.layout.contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contacts.get(position)
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}