package com.example.todolist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread


@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val thread = thread(start = true)
        {

            TodoAdapter.loadFromDataBase()

        }

        val iv_note: ImageView = findViewById(R.id.iv_note)
        val fadingAnimationDuration: Long = 1500
        val splashScreenAlphaInitial = 0f
        val splashScreenAlphaMax = 1f

        iv_note.alpha = splashScreenAlphaInitial
        iv_note.animate().setDuration(fadingAnimationDuration).alpha(splashScreenAlphaMax)
            .withEndAction {

                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                thread.join()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()

            }




    }


}