package Data

import Model.Contact

class Tables {
    abstract class Contacts {
        companion object{
            val _ID="_id"
            val TABLE_NAME="contacts"
            val COLUMN_NAME="name"
            val COLUMN_PHONE="phone"
            val COLUMN_DATE="date"
            val COLUMN_PHONETYPE="phoneType"
            var contacts: MutableList<Contact> = ArrayList()
        }
    }
}