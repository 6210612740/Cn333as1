package com.example.guessnum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var  won : TextView
    lateinit var  num : TextView
    lateinit var  numText : EditText
    lateinit var  numReset : ImageButton
    lateinit var  submit : ImageButton

    var count = 0
    var ans: Int = nextInt(1,1000)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        won = findViewById(R.id.won)
        num = findViewById(R.id.num)
        numText = findViewById(R.id.numText)
        numReset = findViewById(R.id.numReset)
        submit = findViewById(R.id.submit)

        submit.setOnClickListener {
            val number:Int = numText.text.toString().toInt()

            if(number > ans){
                num.text = "Your Guess is Greater Than the answer"
                numText.text.clear()
                count ++
            }
            else if(number < ans){
                num.text = "Your Guess is Lower Than the answer"
                numText.text.clear()
                count ++
            }
            else if(number == ans){
                won.text = "You've Won!"
                num.text = "Your have guessed " + count + " times"
                numText.text.clear()
            }

        }

        numReset.setOnClickListener{
            ans = nextInt(1,1000)
            num.text = "Make A Guess"
            won.text = ""
            count = 0
            numText.text.clear()

        }
    }
}


