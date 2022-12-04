package app.abdelrahman.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var rollButton: Button
    lateinit var rollImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        declareViews()

        initDiceRoller()


    }



    private fun declareViews() {
        rollButton = findViewById(R.id.roll_button)
        rollImage= findViewById(R.id.roll_image)
    }


    private fun initDiceRoller() {
        rollButton.setOnClickListener {
        rollDice()
        }

    }

    private fun rollDice() {
        val randomNum: Int = Random().nextInt(6)+1

        setDice(randomNum)

    }

    private fun setDice(randomNum: Int) {
        val diceImageResource = when(randomNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        rollImage.setImageResource(diceImageResource)
    }


}