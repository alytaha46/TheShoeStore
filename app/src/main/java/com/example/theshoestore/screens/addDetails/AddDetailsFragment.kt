package com.example.theshoestore.screens.addDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.theshoestore.R
import com.example.theshoestore.baseViewModel.AppViewModel
import com.example.theshoestore.databinding.FragmentAddDetailsBinding


class AddDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAddDetailsBinding
    private val viewModel: AppViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_details,
            container,
            false
        )

        //viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        binding.vm = viewModel
        binding.lifecycleOwner = this
        viewModel.resetAttr()


        viewModel.state.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(
                    AddDetailsFragmentDirections.actionAddDetailsFragmentToShoeListFragment()
                )
                viewModel.onNavigateDone()
            }
        })


        // Inflate the layout for this fragment
        return binding.root
    }

}