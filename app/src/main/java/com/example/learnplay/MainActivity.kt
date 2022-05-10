package com.example.learnplay

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mainlayout=findViewById<ConstraintLayout>(R.id.manlayout)
val learn=findViewById<Button>(R.id.learn)
        val play=findViewById<Button>(R.id.play)
        val frameAnimation: AnimationDrawable = mainlayout.background as AnimationDrawable

        frameAnimation.start()

        val frameAnimation1: AnimationDrawable = learn.background as AnimationDrawable

        frameAnimation1.start()
        val frameAnimation2: AnimationDrawable = play.background as AnimationDrawable

        frameAnimation2.start()

learn.setOnClickListener {

    val intent= Intent(this,Learn::class.java)
    startActivity(intent)

}
        play.setOnClickListener {
            val intent= Intent(this,Play::class.java)
            startActivity(intent)



        }

    }
}