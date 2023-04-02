package com.example.rolldiceapp


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            // calling the rollDice function
            rollDice()
        }
    }


    // creating roll dice function
    private fun rollDice() {
        // show random image for roll dice
        val imageDiceRoll: ImageView = findViewById(R.id.imageView)


        // creating the object of the class Dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // correct guess of the dice image
        val correctGuessedDice = 4
        if(correctGuessedDice >= diceRoll) {
//            PROBLEM: I want to show the toast message when the user guessed the correct dice image
            Toast.makeText(this, "You guessed the correct dice image", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "You guessed the wrong dice image", Toast.LENGTH_SHORT).show()
        }

        // creating condition to show the random dice images
        val setImage = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // setting the image to the image view
        imageDiceRoll.setImageResource(setImage)

    }

    // creating the class that will generate the random numbers
    class Dice(val randomNum: Int) {
        fun roll(): Int {
            return (2..randomNum).random()
        }
    }
}
