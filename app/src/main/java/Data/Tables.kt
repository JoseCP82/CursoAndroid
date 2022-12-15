package Data

import Model.Person

class Tables {
    abstract class Persons {
        companion object{
            val _ID="_id"
            val TABLE_NAME="persons"
            val COLUMN_NAME="name"
            val COLUMN_AGE="age"
            var persons: MutableList<Person> = ArrayList()
        }
    }
}