package com.example.iqbaalrafi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iqbaalrafi.R
import com.example.iqbaalrafi.databinding.FragmentNavigationParentBinding
import com.example.iqbaalrafi.ui.home.HomeFragment

class NavigationParentFragment : Fragment() {

    private var _binding: FragmentNavigationParentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationParentBinding.inflate(inflater, container, false)

        val homeFragment = HomeFragment()
        val profilesFragment = ProfilesFragment()
        val settingsFragment = SettingsFragment()

        setCurrentFragment(homeFragment)

        binding.bottomNavigationView2.setOnItemSelectedListener {
            when(it.itemId){
                R.id.profiles -> setCurrentFragment(profilesFragment)
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.settings -> setCurrentFragment(settingsFragment)
            }
            true
        }

        return binding.root
    }
    private fun setCurrentFragment(fragment: Fragment){
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.parent_fragment, fragment)
            commit()
        }
    }

}