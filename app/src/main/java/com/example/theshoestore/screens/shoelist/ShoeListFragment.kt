package com.example.theshoestore.screens.shoelist

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.theshoestore.R
import com.example.theshoestore.baseViewModel.AppViewModel
import com.example.theshoestore.databinding.FragmentInstructionsBinding
import com.example.theshoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: AppViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_shoe_list,
                container,
                false
            )

        // Get the viewmodel
        //viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        binding.vm = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this
        viewModel.shoe_list.value?.forEach {
            val textView: TextView = TextView(container?.context)
            val str = it.name + " " + it.company + " " + it.size + " " + it.description
            textView.text = str
            textView.gravity = Gravity.CENTER
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30.0F)
            binding.linearLayout.addView(textView)
        }


        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddDetailsFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}