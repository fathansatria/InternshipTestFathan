package com.example.internshiptestfathan.main.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.internshiptestfathan.R
import com.example.internshiptestfathan.databinding.ActivitySplashBinding
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this

        Handler().postDelayed(Runnable {
            val main = Intent(this, MainActivity::class.java)
            startActivity(main)
            finish()
        }, 2000)
    }
}