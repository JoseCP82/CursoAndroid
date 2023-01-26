package Data

import Model.Contact

class Tables {
    abstract class Contacts {
        companion object{
            val _ID="_id"
            val TABLE_NAME="contacts"
            val COLUMN_NAME="name"
            val COLUMN_PHONE="phone"
            var contacts: MutableList<Contact> = ArrayList()
        }
    }
}