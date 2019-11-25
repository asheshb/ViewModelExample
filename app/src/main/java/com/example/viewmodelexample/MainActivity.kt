package com.example.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
        private const val COUNTER_KEY = "COUNTER_KEY"
    }
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate() called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let{
            if(savedInstanceState.containsKey(COUNTER_KEY)){
                counter = savedInstanceState.getInt(COUNTER_KEY)
            }
        }

        counter_text.text = counter.toString()

        increment_counter.setOnClickListener{
            counter++
            counter_text.text = counter.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i(TAG, "onSaveInstanceState called")
        super.onSaveInstanceState(outState)

        outState.putInt(COUNTER_KEY, counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.i(TAG, "onRestoreInstanceState called")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onStart() {
        Log.i(TAG, "onStart() called")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, "onResume() called")
        super.onResume()
    }

    override fun onPause() {
        Log.i(TAG, "onPause() called")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "onStop() called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy() called")
        super.onDestroy()
    }
}
