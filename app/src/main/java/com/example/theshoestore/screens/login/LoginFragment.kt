package com.example.theshoestore.screens.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.theshoestore.R
import com.example.theshoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_login,
                container,
                false
            )

        // Get the viewmodel
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        // Set the viewmodel for databinding - this allows the bound layout access to all of the
        // data in the VieWModel
        binding.vm = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Sets up event listening to navigate the player when the game is finished
        viewModel.completeLogin.observe(viewLifecycleOwner, Observer {
            if (it) {
                val email = viewModel.email.value ?: ""
                val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(email)
                findNavController(this).navigate(action)
                viewModel.onLoginComplete()
            }
        })

        /* old way
        binding.loginButton.setOnClickListener {
            viewModel.onLoginComplete(binding.emailEditText.text, binding.passwordEditText.text)
        }*/
        return binding.root

    }

}