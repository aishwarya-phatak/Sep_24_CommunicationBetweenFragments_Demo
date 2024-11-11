package com.bitcode.sep_24_communicationbetweenfragments_demo

import android.os.Bundle
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
    }
}