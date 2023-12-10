package com.example.iqbaalrafi.ui.home

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresExtension
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iqbaalrafi.data.remote.response.Movies
import com.example.iqbaalrafi.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject
import kotlin.math.log


class HomeFragment : Fragment() {
   private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding
    private val viewModel: HomeViewModel by inject()
    private var list: List<Movies> = listOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }
    private fun observeData(){
        with(viewModel){
            observeMovie.observe(requireActivity()){
                it.let { data ->
                    list = data.body()?.results ?: listOf()
                    with(binding.movieList){
                        adapter = HomeAdapter(list)
                        Log.d("home", "adapter:$adapter")
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }
    private fun init(){
        viewModel.getMovie()
    }
}