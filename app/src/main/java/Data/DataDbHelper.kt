package Data

import Model.Contact
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataDbHelper (context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    private lateinit var db:SQLiteDatabase
    private val values: ContentValues
    companion object {
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="contacts"
    }

    init {

        values=ContentValues()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE "+Tables.Contacts.TABLE_NAME+" (" +
                Tables.Contacts._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Tables.Contacts.COLUMN_NAME + " TEXT NOT NULL," +
                Tables.Contacts.COLUMN_PHONE + " TEXT NOT NULL)");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert(contact: List<Contact>) {
        db=this.writableDatabase
        values.put(Tables.Contacts.COLUMN_NAME,contact[0].getName())
        values.put(Tables.Contacts.COLUMN_PHONE,contact[0].getPhone())
        db.insert(Tables.Contacts.TABLE_NAME,null,values)
    }

    fun getAll():MutableList<Contact>{
        db=this.readableDatabase
        val contacts:MutableList<Contact> = ArrayList()

        return contacts
    }
}