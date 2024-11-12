package com.bitcode.sep_24_communicationbetweenfragments_demo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB
    private var fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        fragmentA = fragmentManager.findFragmentById(R.id.fragmentA) as FragmentA
        fragmentB = fragmentManager.findFragmentById(R.id.fragmentB) as FragmentB

        fragmentA.onNameSetListener = MyOnNameSetListener()
        fragmentB.onCitySetListener = MyOnCitySetListener()
    }


    inner class MyOnNameSetListener : FragmentA.OnNameSetListener{
        override fun onNameSet(text: String) {
            Toast.makeText(this@MainActivity,"on Name Set Method", Toast.LENGTH_LONG).show()
            fragmentB.text1 = text
        }
    }

    inner class MyOnCitySetListener : FragmentB.OnCitySetListener{
        override fun onCitySet(text: String) {
            Toast.makeText(this@MainActivity,"onCitySet Method", Toast.LENGTH_LONG).show()
            fragmentA.text = text
        }
    }

    //way 2 - passing data through Main Activity from fragment A to fragment B and vice versa
//    fun setDataToFragmentA(text : String){
//        fragmentA.text = text
//    }
//
//    fun setDataToFragmentB(text : String){
//        fragmentB.text1 = text
//    }
}