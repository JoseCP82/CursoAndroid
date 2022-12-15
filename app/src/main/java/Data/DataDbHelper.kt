package Data

import Model.Person
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.concurrent.locks.Condition

class DataDbHelper (context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    private val db:SQLiteDatabase
    private val values: ContentValues
    companion object {
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="persons"
    }

    init {
        db=this.writableDatabase
        values=ContentValues()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE "+Tables.Persons.TABLE_NAME+" (" +
                Tables.Persons._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Tables.Persons.COLUMN_NAME + " TEXT NOT NULL," +
                Tables.Persons.COLUMN_AGE + " TEXT NOT NULL)");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert(person: List<Person>) {
        values.put(Tables.Persons.COLUMN_NAME,person[0].getName())
        values.put(Tables.Persons.COLUMN_AGE,person[0].getAge())
        db.insert(Tables.Persons.TABLE_NAME,null,values)
    }
}