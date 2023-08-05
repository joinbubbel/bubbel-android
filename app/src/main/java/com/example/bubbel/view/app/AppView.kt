package com.example.bubbel.view.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bubbel.R
import com.example.bubbel.databinding.AppScreenBinding
import com.example.bubbel.viewmodel.app.AppViewModel

class AppView : Fragment() {
    private lateinit var binding: AppScreenBinding
    private val viewModel: AppViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AppScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up initial fragment
        replaceFragment(HomeView()) // Initial Fragment

        // Set the onNavigationItemSelectedListener for the BottomNavigationView
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(HomeView())
                R.id.clubs -> replaceFragment(ClubView())
                R.id.messages -> replaceFragment(MessageView())
                R.id.profile -> replaceFragment(ProfileView())
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        childFragmentManager.beginTransaction().replace(R.id.flFragment, fragment).commit()
        return true
    }
}
