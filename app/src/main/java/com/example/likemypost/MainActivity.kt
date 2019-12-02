package com.example.likemypost

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    //initialise the value
    var up: Int = 0
    var down: Int = 0
    lateinit var sharedPreferences: SharedPreferences

    //TODO: Fix the shared preference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        Log.d("MainActivity", "onCreate")
        //assign the value to the TextView
        textViewLike.text = up.toString()
        textViewDislike.text = down.toString()

        imageViewLike.setOnClickListener{
            up++
            textViewLike.text = up.toString()
        }
        imageViewDislike.setOnClickListener{
            down++
            textViewDislike.text = down.toString()
        }

    }

    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        up = sharedPreferences.getInt(getString(R.string.up),0)
        down = sharedPreferences.getInt(getString(R.string.down),0)

        Log.d("MainActivity", "onResume")
        super.onResume()
    }
    override fun onPause() {
        Log.d("MainActivity", "onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.up), up)
            putInt(getString(R.string.down),down)
            apply()
        }
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop")
        super.onStop()
    }
    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }
}

