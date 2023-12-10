package com.example.iqbaalrafi.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.iqbaalrafi.R
import com.example.iqbaalrafi.data.local.UserEntity
import com.example.iqbaalrafi.databinding.FragmentRegisterBinding
import org.koin.android.ext.android.inject


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }

    private fun observeData() {
        with(viewModel){
            observeIsRegister().observe(viewLifecycleOwner){
                it.let { data ->
                    if (data){
                        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                    } else {
                        Toast.makeText(requireContext(), "Email Sudah Terdaftar", Toast.LENGTH_SHORT)
                    }
                }
            }
        }
    }
    private fun init() {
        binding.buttonGetStarted.setOnClickListener {
            val name = binding.etNama.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val user = UserEntity(0, name, email, password)
            viewModel.insertUser(user)

        }
    }
}