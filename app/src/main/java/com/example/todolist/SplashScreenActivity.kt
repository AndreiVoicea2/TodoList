package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var iv_note: ImageView = findViewById(R.id.iv_note)

        val FadingAnimationDuration: Long = 1500
        val SplashScreenAlphaInitial: Float = 0f
        val SplashScreenAlphaMax: Float = 1f

        iv_note.alpha = SplashScreenAlphaInitial
        iv_note.animate().setDuration(FadingAnimationDuration).alpha(SplashScreenAlphaMax).withEndAction{

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()

        }

    }
}