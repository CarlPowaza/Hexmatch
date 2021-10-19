package com.example.hexmatch

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log


import android.widget.Button
import androidx.appcompat.app.AppCompatActivity





// a lot of the logic for the game was found
//https://www.youtube.com/watch?v=BGvjScKcW1s
class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        val arr: MutableList<String> = mutableListOf("1", "2", "3", "1", "2", "3")
        var solved:MutableList<Boolean> = mutableListOf(false,false,false,false,false,false)


        val good: MediaPlayer = MediaPlayer.create(this@GameActivity, R.raw.good)
        val bad: MediaPlayer = MediaPlayer.create(this@GameActivity, R.raw.bad)
        val victory: MediaPlayer = MediaPlayer.create(this@GameActivity, R.raw.victory)

        val buttons: Array<Button> = arrayOf(
            findViewById(R.id.top_left),
            findViewById(R.id.top_mid),
            findViewById(R.id.top_right),
            findViewById(R.id.mid_left),
            findViewById(R.id.mid_mid),
            findViewById(R.id.mid_right)
        )
        //array to store all the buttons


        var lastClicked:Int =-1
        var clickedOnce:Boolean =false


        arr.shuffle()
        for (i in 0..5) {

            buttons[i].setOnClickListener {
                if(!solved[i]) {

                    buttons[i].setText(arr[i])
                    if (!clickedOnce) {
                        lastClicked = i
                        clickedOnce = true

                    } else if (arr[i] == arr[lastClicked]) {

                            solved[i] = true
                            solved[lastClicked] = true
                            lastClicked =-1
                            clickedOnce = false
                            good.start()
                            clear(buttons,solved)


                        }
                    else{
                        clear(buttons,solved)
                        lastClicked =-1
                        clickedOnce = false
                        bad.start()


                    }
                    if(done(solved)){
                        victory.start()
                        startActivity(Intent(this@GameActivity,MainActivity::class.java))
                    }

                    }
                }


                }//     if (clicked[i] == 0)

            }

    private fun done(solved:MutableList<Boolean>):Boolean{
        for (i in 0..solved.size-1){
            if(!solved[i])return false
        }
        return true
    }
    private fun clear( buttons: Array<Button>,solved:MutableList<Boolean>){
        for(i in 0..buttons.size-1){
            if(solved[i])  buttons[i].setText("X")
            else  buttons[i].setText("")


        }
    }


}
