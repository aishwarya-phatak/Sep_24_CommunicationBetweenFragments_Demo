package com.bitcode.sep_24_communicationbetweenfragments_demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {
        private lateinit var fragmentB: FragmentB
        private lateinit var edtCity : EditText
        private lateinit var btnSend : Button

        var text1 = ""
        set(value) {
            field = value
            fragmentB.edtCity.setText(value)
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = layoutInflater.inflate(R.layout.fragment_b, null)

        edtCity = view.findViewById(R.id.edtCity)
        btnSend = view.findViewById(R.id.btnSend)
        btnSend.setOnClickListener {
        (parentFragmentManager.findFragmentById(R.id.fragmentA) as FragmentA).text =
            fragmentB.text1.toString()
        }

        return view
    }
}