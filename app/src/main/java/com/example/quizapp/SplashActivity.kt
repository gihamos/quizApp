package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val tvMessage = findViewById<TextView>(R.id.tvSplashMessage)

        // Animation zoom + fade-in
        val zoomInFade = AnimationUtils.loadAnimation(this, R.anim.zoom_in_fade)
        tvMessage.startAnimation(zoomInFade)

        // Attendre 3 secondes puis lancer ProfileActivity avec transition
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)

            // Transition animée (choisis fade ou slide)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            // ou : overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

            finish()
        }, 3000)
    }
}