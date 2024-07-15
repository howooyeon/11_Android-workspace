package com.guru.groupapp

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editName : EditText
    lateinit var editNumber: EditText
    lateinit var editNameResult : EditText
    lateinit var editNumberResult: EditText
    lateinit var btnInit: Button
    lateinit var btnInsert : Button
    lateinit var btnSelect : Button

    lateinit var myHelper: myDBHelper
    lateinit var sqlDB : SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.editName)
        editNumber = findViewById(R.id.editNumber)
        editNameResult = findViewById(R.id.editNameResult)
        editNumberResult = findViewById(R.id.editNumberResult)

        btnInit = findViewById(R.id.btnInit)
        btnInsert = findViewById(R.id.btnInsert)
        btnSelect = findViewById(R.id.btnSelect)

        myHelper = myDBHelper(this)

        btnInit.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            myHelper.onUpgrade(sqlDB, 1, 2)
            sqlDB.close()
        }

        btnInsert.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO groupTBL VALUES('"+editName.text.toString()+"', "+
                    editNumber.text.toString() + ");")
            sqlDB.close()
            Toast.makeText(applicationContext, "압력됨", Toast.LENGTH_SHORT).show()
        }

        btnSelect.setOnClickListener {
            sqlDB = myHelper.readableDatabase

            var cursor : Cursor
            cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null)
            var strNames = "그룹이름" + "\r\n" + "-----" +"\r\n"
            var strNumbers = "인원" + "\r\n" + "-----" +"\r\n"

            while(cursor.moveToNext()){
                strNames += cursor.getString(0) + "\r\n"
                strNumbers += cursor.getString(1) + "\r\n"
            }

            editNameResult.setText(strNames)
            editNumberResult.setText(strNumbers)

            cursor.close()
            sqlDB.close()

        }

    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE groupTBL (gName CHAR(20) PRIMARY KEY, gNumber Integer);")
        }

        override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS groupTBL")
            onCreate(db)

        }

    }
}