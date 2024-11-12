package com.bitcode.sep_24_communicationbetweenfragments_demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.bitcode.sep_24_communicationbetweenfragments_demo.databinding.FragmentBBinding

class FragmentB : Fragment() {
        private lateinit var fragmentBBinding: FragmentBBinding
        private lateinit var edtCity : EditText
        private lateinit var btnSend : Button

        var text1 = ""
        set(value) {
            field = value
            fragmentBBinding.edtCity.setText(value)
        }

    interface OnCitySetListener{
        fun onCitySet(text : String)
    }

    lateinit var onCitySetListener: OnCitySetListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       fragmentBBinding = FragmentBBinding.inflate(layoutInflater)

        fragmentBBinding.btnSend.setOnClickListener {
            onCitySetListener.onCitySet(fragmentBBinding.edtCity.text.toString())

            //way 2
//            (requireActivity() as MainActivity).setDataToFragmentA(
//                fragmentBBinding.edtCity.text.toString())

            //way 1 - direct passing of data between two fragments
//            (parentFragmentManager.findFragmentById(R.id.fragmentA) as FragmentA).text =
//                fragmentBBinding.edtCity.text.toString()
        }
        return fragmentBBinding.root
    }
}