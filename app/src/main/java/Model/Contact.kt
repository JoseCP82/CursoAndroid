package Model

import java.time.LocalDate
import java.util.Date

class Contact() {

    private var id: Int = 0
    private var name: String = ""
    private var phone: String = ""
    private var date: String = ""
    private var phoneType: String = ""

    constructor(id: Int, name: String, phone: String, date: String, phoneType: String) : this() {
        this.id=id
        this.name=name
        this.phone=phone
        this.date=date
        this.phoneType=phoneType
    }

    constructor(name: String, phone: String, date: String, phoneType: String) : this() {
        this.name=name
        this.phone=phone
        this.date=date
        this.phoneType=phoneType
    }

    constructor(id: Int, name: String, phone: String) : this() {
        this.id=id
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

    fun getDate():String {
        return date
    }

    fun getPhoneType():String {
        return phoneType
    }

    override fun toString(): String {
        return "Contact(id=$id, name='$name', phone='$phone', date='$date', phoneType='$phoneType')"
    }
}