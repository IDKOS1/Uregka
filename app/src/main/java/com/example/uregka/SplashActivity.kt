package com.example.uregka

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class SplashActivity : AppCompatActivity() {

    private lateinit var configuration: Configuration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        configuration = resources.configuration
        //언어 설정
        configuration.locale = Locale.KOREAN
        configuration.locale = Locale.US

        resources.updateConfiguration(configuration,resources.displayMetrics)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)



    }
}