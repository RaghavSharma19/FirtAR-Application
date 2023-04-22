package org.tensorflow.lite.examples.detection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.view.View;


class setCaloryGoalbyraghav : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_calory_goalbyraghav)

        val seek = findViewById<SeekBar>(R.id.seekBarCal)
        val calorieText = findViewById<TextView>(R.id.calorieText)
        var startPoint = 1000
        var endPoint = 3000
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                // write custom code for progress is changed
                calorieText.text = (progress*50).toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
                calorieText.text = (seek.progress*25).toString()
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped

            }
        })
        val confirmBtn = findViewById<Button>(R.id.confirmDetails)
        confirmBtn.setOnClickListener(){
            callActivity()
        }

    }

    private fun callActivity() {
        val calorieText = findViewById<TextView>(R.id.calorieText)
        val message = calorieText.toString()
        val intent = Intent(this,MainActivity::class.java).also {
            it.putExtra("EXTRA_MESSAGE", message)
            startActivity(it)
        }


    }
}