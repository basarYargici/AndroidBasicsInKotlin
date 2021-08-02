package com.example.unit1pathway4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClickRollButton();
    }

    /**
     * Roll the dice and change the screen with the result.
     */
    private fun onClickRollButton() {
        val rollButton: Button = findViewById(R.id.btnRoll)

        rollButton.setOnClickListener {
            // First step
//            Toast.makeText(this, "Dice Rolled!",Toast.LENGTH_LONG).show()

            // Second step
//            val resultTextView: TextView = findViewById(R.id.tvResultNumber)
//            changeResultNumber(resultTextView)

            // Third step
            val diceImageView: ImageView = findViewById(R.id.ivDice)
            val diceNumber: Int = rollDice()

            // Determine which drawable resource ID to use based on the dice roll
            val drawableResource = when (diceNumber) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            // Update the ImageView resource and description
            diceImageView.setImageResource(drawableResource)
            diceImageView.contentDescription = diceNumber.toString()
        }
    }

    /**
     * Roll the dice.
     */
    private fun rollDice(): Int {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        return dice.roll()
    }

    /**
     * Update the given TextView with diceRoll() method.
     */
    private fun changeResultNumber(resultTextView: TextView) {
        // Update the screen with the dice roll
        resultTextView.text = rollDice().toString()
    }
}