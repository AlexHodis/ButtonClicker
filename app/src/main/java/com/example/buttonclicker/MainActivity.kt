package com.example.buttonclicker

import android.graphics.Color
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //private Button button;   In java
    //var or val : variable vs constant
    //var varName : DataType
    // lateinit is a promise to initilize a variable later before using it
    //Kotlin can infer data types. can also be written var timesClicked : Int = 0

    lateinit var buttonClicker : Button
    var timesClicked = 0
    var rotate = 0f
    var translate = 0f
    var textSize = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //wire widgets -- link the xml widgets to our kotlin code
        buttonClicker = findViewById(R.id.button_main_clicker)
        buttonClicker.text = "CLICK NOW!"

        //react to a click to increase timesClicked variable
        buttonClicker.setOnClickListener {
       //in between the braces, put code that should happen after a click
            timesClicked++
          //  buttonClicker.text = "Times Clicked: " + timesClicked (java way)
            buttonClicker.text = "Times Clicked: $timesClicked"

            buttonClicker.rotation = rotate++

            translate += 10

            buttonClicker.translationY = translate



            // toast the user when they have clicked 10 times
            if(timesClicked == 10) {
                //context in android is the activity you are currently in
                //usually the keyword this
                //sometimes need to specify this@ActivityName
                Toast.makeText(this@MainActivity, "You Have Mail!", Toast.LENGTH_SHORT).show()
                buttonClicker.setTextColor(Color.rgb(255, 255, 0))
            }

            if(timesClicked == 20){
                Toast.makeText(this@MainActivity, "Nice!", Toast.LENGTH_SHORT).show()
                buttonClicker.textSize++
            }

            if(timesClicked == 30){
                Toast.makeText(this@MainActivity, "Red???", Toast.LENGTH_SHORT).show()
                buttonClicker.setBackgroundColor(Color.rgb(255,100,100))
            }

            if(timesClicked == 80){
                Toast.makeText(this@MainActivity, "Don't Lose My Button!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}