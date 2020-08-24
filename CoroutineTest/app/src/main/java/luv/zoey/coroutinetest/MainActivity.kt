package luv.zoey.coroutinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawNumNoSuspend()
        Log.d(TAG,"All Number Draw")

    }

    fun drawNumSuspend(){
        GlobalScope.launch {
            one()
            two()
            three()
        }
    }
    fun drawNumNoSuspend(){
        GlobalScope.launch {
            one1()
            two2()
            three3()
        }
    }

    suspend fun one() {
        delay(1000)
        Log.d(TAG, "Draw One")
    }

    suspend fun two() {
        delay(1000)
        Log.d(TAG, "Draw Two")
    }

    suspend fun three() {
        delay(1000)
        Log.d(TAG, "Draw Three")
    }
    fun one1(){
        Log.d(TAG, "Draw One No susend")
    }
    fun two2(){
        Log.d(TAG, "Draw Two No susend")
    }
    fun three3(){
        Log.d(TAG, "Draw Three No susend")
    }

}