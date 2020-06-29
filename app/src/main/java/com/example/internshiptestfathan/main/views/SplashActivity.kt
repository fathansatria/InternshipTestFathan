package com.example.internshiptestfathan.main.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.internshiptestfathan.R
import com.example.internshiptestfathan.databinding.ActivitySplashBinding
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var viewModel: SplashViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        binding.splash = viewModel

//        Handler().postDelayed(Runnable {
//            val main = Intent(this, MainActivity::class.java)
//            startActivity(main)
//            finish()
//        }, 2000)

        viewModel.getGallery()
        viewModel.getPlaces()

        observeData()
    }

    private fun observeData() {
        viewModel.isGalleriesDone.observe(this, Observer { galleryDone ->
            if (galleryDone) {
                viewModel.isPlaceDone.observe(this, Observer { placeDone ->
                    if(placeDone){
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                        finish()
                    }
                })

            }
        })
    }
}