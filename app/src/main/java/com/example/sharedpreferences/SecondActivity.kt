package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.sharedpreferences.UserVipApplication.Companion.prefs

class SecondActivity : AppCompatActivity() {

        lateinit var btnLogout: Button
        lateinit var tvName: TextView
        lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initNameAndColor()
        initUI()
    }
    fun initUI() {
        btnLogout=findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }

    }
    fun initNameAndColor(){
        tvName=findViewById(R.id.tvName)
        val userName = prefs.getName()
        tvName.text = "Bienvenido $userName"
        if(prefs.getVIP()){
            setVIPColorBackground()
        }
    }
    fun setVIPColorBackground(){
        container=findViewById(R.id.container)
        container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip_yellow))
    }

}