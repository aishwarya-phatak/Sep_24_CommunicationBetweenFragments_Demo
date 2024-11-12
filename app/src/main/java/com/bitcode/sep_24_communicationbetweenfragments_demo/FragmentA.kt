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
    private lateinit var edtName : EditText
    private lateinit var btnSend : Button
    private lateinit var fragmentABinding : FragmentABinding

        var text = ""
        set(value) {
            field = value
            fragmentABinding.edtName.setText(value)
        }

    interface OnNameSetListener{
        fun onNameSet(text : String)
    }

    lateinit var onNameSetListener : OnNameSetListener

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       fragmentABinding = FragmentABinding.inflate(layoutInflater)

        fragmentABinding.btnSend.setOnClickListener {

            onNameSetListener.onNameSet(fragmentABinding.edtName.text.toString())
        //way 2
//            (requireActivity() as MainActivity).setDataToFragmentB(fragmentABinding.edtName.text.toString())

            //way 1 - direct passing of data between two fragments
//            (parentFragmentManager.findFragmentById(R.id.fragmentB) as FragmentB).text1 =
//                fragmentABinding.edtName.text.toString()
        }
        return fragmentABinding.root
    }
}