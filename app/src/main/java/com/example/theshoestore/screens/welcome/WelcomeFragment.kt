package com.example.theshoestore.screens.welcome

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.theshoestore.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val loginFragmentArgs by navArgs<WelcomeFragmentArgs>()
        Log.e("TAG", "onCreateView: $loginFragmentArgs.email", )
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)

    }
}