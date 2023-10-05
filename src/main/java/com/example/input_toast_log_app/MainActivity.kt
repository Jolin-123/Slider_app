package com.example.input_toast_log_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Switch
import android.widget.Toast
import com.example.slider_app.R


const val TAG = "MainActivity"



class MainActivity : AppCompatActivity() {
    // declare variables at the top of the override function
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    private lateinit var myText: EditText
    private lateinit var mySwitch: Switch
    private lateinit var mySeekBar: SeekBar   // why do we use lateinit ?

    // Boolean variable set as "false" first
    private var switchPosition = false

    // private variables continuous
    private val myButtonClickListener = View.OnClickListener {
        val btn = (it as Button)
        val btnText = btn.text
        Log.i(TAG, "$btnText was cliked ")
    }

    private val myButtonLongClickListener = View.OnLongClickListener {
        val btn = (it as Button)
        val btnText = btn.text
        Log.i(TAG, "$btnText was long pressed ")
        true // why do we need true here?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        myText = findViewById(R.id.edit_text)
        mySwitch = findViewById(R.id.my_switch)
        mySeekBar = findViewById(R.id.seekBar)

        switchPosition = mySwitch.isChecked
        button1.setOnClickListener{
            val btn = (it as Button)
            if (switchPosition) {
                val toast = Toast.makeText(this, R.string.switch_was_on, Toast.LENGTH_SHORT )
            } else {
                val toast = Toast.makeText(this, R.string.switch_was_off,  Toast.LENGTH_LONG)
            }
            // persistent string
            btn.text = this.getString(R.string.clicked_button)
            Log.i(TAG, "button 1 was clicked")
        }// End of serOnClickListener

        button2.setOnClickListener(myButtonClickListener)
        button3.setOnClickListener(myButtonClickListener)

        button2.setOnLongClickListener(myButtonLongClickListener)
        button3.setOnLongClickListener(myButtonLongClickListener)

        mySwitch.setOnClickListener {
            val sw = (it as Switch)
            switchPosition = sw.isChecked
            Log.i(TAG, "Switch is clicked to ${sw.isChecked}")
        }  //  mySwitch.setOnClickListener

        mySeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(sb: SeekBar?, p1: Int, p2: Boolean) {
                Log.i(TAG, "the value of the seekbar is ${sb?.progress}")

                var that =  sb?.progress
            }

            override fun onStartTrackingTouch(p0: SeekBar?) { }
            override fun onStopTrackingTouch(p0: SeekBar?) { }
        } )

    }// End of oerride fun onCreate ()

}// End of class MainActivity : AppCompatActivity()