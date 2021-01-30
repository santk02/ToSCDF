package com.example.toscdf

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQuery
import android.provider.BaseColumns
import java.lang.NumberFormatException

class database(context: Context) : SQLiteOpenHelper(context, dbname,null,version  )
{
    object credentials : BaseColumns
    {
        val email = "username"
        var number = "number"
        val confirm_password = "confirm password"
        val password = "password"
        val role = "role"
    }
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${credentials} (" +
                "${credentials.email} varchar," +
                "${credentials.password} varchar,"+
                "${credentials.number} integer(10)," +
                "${credentials.confirm_password} varchar,+" +
                "${credentials.role} val)"

        )
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun dataentry(email:String,password:String,confirm_password:String,number:String,role:String)
    {
        val db:SQLiteDatabase = writableDatabase
        val values = ContentValues().apply {
            put("username",email)
            put("password",password)
            put("confirm password",confirm_password)
            put("number",number)
            put("role",role)
        }
        db.insert("credentials", null, values)
        db.close()
    }
    fun userpresent(email:String,password:String):Boolean
    {
        val db = writableDatabase
        val query = "SELECT * FROM crendentials WHERE email = '$email' and password = '$password'"
        val cursor = db.rawQuery(query,null)
        if(cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
    companion object{
        internal var dbname = "credentials"
        internal var version = 1
    }

}

