package com.example.sharedpreferences

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.example.sharedpreferences.UserVipApplication.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        checkUserValues()
    }

    fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }


    fun initUI(){
        binding.btnContinue.setOnClickListener { accessToDetail() }

    }


    fun accessToDetail(){

        if (binding.etName.text.toString().isNotEmpty()){
            prefs.saveName(binding.etName.text.toString())
            prefs.saveVIP(binding.cbVip.isChecked)
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