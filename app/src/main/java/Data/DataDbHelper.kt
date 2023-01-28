package Data

import Model.Contact
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataDbHelper (context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object {
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="contacts"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblContacts = ("CREATE TABLE "+Tables.Contacts.TABLE_NAME+" (" +
                Tables.Contacts._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Tables.Contacts.COLUMN_NAME + " TEXT NOT NULL," +
                Tables.Contacts.COLUMN_PHONE + " TEXT NOT NULL," +
                Tables.Contacts.COLUMN_DATE + " TEXT NOT NULL," +
                Tables.Contacts.COLUMN_PHONETYPE + " TEXT NOT NULL)");
        db?.execSQL(createTblContacts)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS "+Tables.Contacts.TABLE_NAME)
        onCreate(db)
    }

    fun insertContact(contact: Contact): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(Tables.Contacts.COLUMN_NAME, contact.getName())
        contentValues.put(Tables.Contacts.COLUMN_PHONE, contact.getPhone())
        contentValues.put(Tables.Contacts.COLUMN_DATE, contact.getDate())
        contentValues.put(Tables.Contacts.COLUMN_PHONETYPE, contact.getPhoneType())

        val success = db.insert(Tables.Contacts.TABLE_NAME, null, contentValues)
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun getAllContacts(): ArrayList<Contact> {
        val contacts: ArrayList<Contact> = ArrayList()
        val query = "SELECT * FROM "+Tables.Contacts.TABLE_NAME
        val db = this.readableDatabase
        val cursor: Cursor?

        try {
            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(query)
            return ArrayList()
        }

        var id: Int
        var name: String
        var phone: String

        if(cursor.moveToFirst()) {
            do {
                id=cursor.getInt(cursor.getColumnIndex(Tables.Contacts._ID))
                name=cursor.getString(cursor.getColumnIndex(Tables.Contacts.COLUMN_NAME))
                phone=cursor.getString(cursor.getColumnIndex(Tables.Contacts.COLUMN_PHONE))

                val contact = Contact(id=id, name=name, phone=phone)
                contacts.add(contact)
            }while(cursor.moveToNext())
        }
        return contacts
    }
}