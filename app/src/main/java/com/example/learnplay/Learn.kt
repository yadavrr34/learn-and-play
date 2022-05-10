package com.example.learnplay

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import java.util.*

class Learn : AppCompatActivity() {
    private var colorvalue=0
    private var mTTS: TextToSpeech? = null
    var speakcolor:String?=""
    private var a= arrayOf(Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN,Color.WHITE,
        Color.BLACK,Color.GRAY,Color.MAGENTA,Color.CYAN)
    private var b= arrayOf("RED","BLUE","YELLOW","GREEN","WHITE","BLACK","GRAY","MAGNETA","CYAN")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)
        val colorname=findViewById<TextView>(R.id.colorname)
// **************************code for speak
        mTTS = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = mTTS!!.setLanguage(Locale.ENGLISH)
                if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED
                ) {
                    Log.e("TTS", "Language not supported")
                } else {
                }
            } else {
                Log.e("TTS", "Initialization failed")
            }
        }
        //***********************************


        val colorimg=findViewById<LinearLayout>(R.id.colorlayout)
        if(colorvalue==0) {
            colorimg.setBackgroundColor(a[colorvalue])
            colorname.text = b[colorvalue]
        }


    }
//**********************  left arrow function ********************************** */
      fun leftArrow(v: View)
    {
        val left=findViewById<Button>(R.id.left)
        val right=findViewById< Button>(R.id.right)

        if(colorvalue>0) {

            colorvalue -= 1
right.isEnabled=true
    val colorname = findViewById<TextView>(R.id.colorname)

    val colorimg = findViewById<LinearLayout>(R.id.colorlayout)
    colorimg.setBackgroundColor(a[colorvalue])
    colorname.text = b[colorvalue]
            colorname.setTextColor(a[colorvalue])
            speakcolor=b[colorvalue]
            speak()
}
        else
{
    left.isEnabled=false
}
    }

    //**********************************rightarrow   *********************************** /
      fun rightArrow(v:View)
    {          val right=findViewById< Button>(R.id.right)
        val left=findViewById<Button>(R.id.left)

        if(colorvalue<8) {

    colorvalue++
            left.isEnabled=true
    val colorname = findViewById<TextView>(R.id.colorname)

    val colorimg = findViewById<LinearLayout>(R.id.colorlayout)
    colorimg.setBackgroundColor(a[colorvalue])
    colorname.text = b[colorvalue]
            colorname.setTextColor(a[colorvalue])
            speakcolor=b[colorvalue]
            speak()

}
        else
{
    right.isEnabled=false
}
    }

// ********************************text to speech code***********************************/
    private fun speak() {

    mTTS?.speak(speakcolor, TextToSpeech.QUEUE_FLUSH, null)
    }

    override fun onDestroy() {
        if (mTTS != null) {
            mTTS!!.stop()
            mTTS!!.shutdown()
        }
        super.onDestroy()
    }


}