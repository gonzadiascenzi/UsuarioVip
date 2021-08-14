package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.example.sharedpreferences.UserVipApplication.Companion.prefs

class MainActivity : AppCompatActivity() {

    lateinit var btnContinue: Button
    lateinit var etName: EditText
    lateinit var cbVip: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        checkUserValues()
    }

    fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }


    fun initUI(){
     btnContinue=  findViewById(R.id.btnContinue)
     btnContinue.setOnClickListener { accessToDetail() }

    }


    fun accessToDetail(){
        etName = findViewById(R.id.etName)
        cbVip = findViewById(R.id.cbVip)
        if (etName.text.toString().isNotEmpty()){
            prefs.saveName(etName.text.toString())
            prefs.saveVIP(cbVip.isChecked)
            goToDetail()

        }
        else{
            //Haz esto
        }
    }

    fun goToDetail(){
        startActivity(Intent(this, SecondActivity::class.java))
    }
}