package com.bitcode.sep_24_communicationbetweenfragments_demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.bitcode.sep_24_communicationbetweenfragments_demo.databinding.FragmentABinding

class FragmentA : Fragment() {
    private lateinit var fragmentA : FragmentA
    private lateinit var edtName : EditText
    private lateinit var btnSend : Button

    private lateinit var fragmentABinding : FragmentABinding

        var text = ""
        set(value) {
            field = value
            fragmentA.edtName.setText(value)
        }

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentABinding = FragmentABinding.inflate(layoutInflater)

        val view = inflater.inflate(R.layout.fragment_a,null)
        edtName = view.findViewById(R.id.edtName)
        btnSend = view.findViewById(R.id.btnSend)
        btnSend.setOnClickListener {

            //way 1
            (parentFragmentManager.findFragmentById(R.id.fragmentB) as FragmentB).text1 =
                fragmentA.edtName.text.toString()
        }

        return view
    }
}