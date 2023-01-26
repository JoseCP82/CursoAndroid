package Model

import java.time.LocalDate
import java.util.Date

class Contact() {

    private var id: Int = 0
    private var name: String = ""
    private var phone: String = ""
    //private var date: Date;


    constructor(name: String, phone: String) : this() {
        this.name=name
        this.phone=phone
    }

    fun getId():Int {
        return id;
    }

    fun getName():String {
        return name
    }

    fun getPhone():String {
        return phone
    }

    override fun toString(): String {
        return "Contact(id=$id, name='$name', phone=$phone)"
    }
}