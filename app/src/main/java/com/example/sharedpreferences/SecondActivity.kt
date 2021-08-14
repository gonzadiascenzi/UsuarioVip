package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.sharedpreferences.UserVipApplication.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityMainBinding
import com.example.sharedpreferences.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNameAndColor()
        initUI()
    }
    fun initUI() {
        binding.btnLogout.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }

    }
    fun initNameAndColor(){
        val userName = prefs.getName()
        binding.tvName.text = "Bienvenido $userName"
        if(prefs.getVIP()){
            setVIPColorBackground()
        }
    }
    fun setVIPColorBackground(){
        binding.container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip_yellow))
    }

}