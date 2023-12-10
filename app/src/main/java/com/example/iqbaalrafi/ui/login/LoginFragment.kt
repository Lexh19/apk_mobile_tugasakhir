package com.example.iqbaalrafi.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.iqbaalrafi.R
import com.example.iqbaalrafi.databinding.FragmentLoginBinding
import org.koin.android.ext.android.inject


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

       init()
        observeData()

        return binding.root
    }

    private fun observeData() {
        with(viewModel){
            observeIsLogin().observe(requireActivity()){
                it.let { data ->
                    if (data != null){
                        Log.d("login", "data:$data")
                        findNavController().navigate(R.id.action_loginFragment_to_navigationParentFragment)
                    } else {
                        Toast.makeText(requireContext(), "Email atau Password Salah", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun init() {
        with(binding){
            buttonLogin.setOnClickListener{
                if (etEmail.text.isNullOrBlank()){
                    etEmail.error = "Email Masih Kosong"
                }
                if (etPassword.text.isNullOrBlank()){
                    etPassword.error = "Password Masih Kosong"
                }
                if (!etEmail.text.isNullOrBlank() && !etPassword.text.isNullOrBlank()){
                    viewModel.getDataLogin(etEmail.text.toString(), etPassword.text.toString())
                }
            }
            textRegister.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }

}