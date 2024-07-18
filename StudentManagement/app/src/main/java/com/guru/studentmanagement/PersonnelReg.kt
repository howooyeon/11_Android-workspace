package com.guru.studentmanagement

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.provider.Telephony
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class PersonnelReg : AppCompatActivity() {
    lateinit var dbManager: DBManager
    lateinit var sqlitedb : SQLiteDatabase

    lateinit var btnRegister : Button
    lateinit var editName : EditText
    lateinit var editAge : EditText
    lateinit var editTel : EditText
    lateinit var rb_gender : RadioGroup
    lateinit var rb_gender_m : RadioButton
    lateinit var rb_gender_f : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_reg)

        btnRegister = findViewById(R.id.btnRegister)
        editName = findViewById(R.id.editName)
        editAge = findViewById(R.id.editAge)
        editTel = findViewById(R.id.editTel)
        rb_gender = findViewById(R.id.gender)
        rb_gender_f = findViewById(R.id.female)
        rb_gender_m = findViewById(R.id.male)

        dbManager = DBManager(this, "personnelDB", null, 1)

        btnRegister.setOnClickListener {
            var str_name: String = editName.text.toString()
            var str_age : String = editAge.text.toString()
            var str_tel : String = editTel.text.toString()

            var str_gender :String = ""
            if(rb_gender.checkedRadioButtonId == R.id.male){
                str_gender = rb_gender_m.text.toString()
            }
            if(rb_gender.checkedRadioButtonId == R.id.female){
                str_gender = rb_gender_f.text.toString()
            }

            sqlitedb = dbManager.writableDatabase
            sqlitedb.execSQL("INSERT INTO personnel VALUES ('" +str_name+"', '"+str_gender+"', " +str_age+", '"+str_tel+"')")
            sqlitedb.close()

            val intent = Intent(this, PersonnelInfo::class.java)
            intent.putExtra("intent_name", str_name)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_personnel_reg, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.action_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_list -> {
                val intent = Intent(this, PersonnelList::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}