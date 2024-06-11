package com.example.pureattire_capstoneproject_info6134.fragments.LoginRegister

import androidx.fragment.app.Fragment
import com.example.pureattire_capstoneproject_info6134.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import com.example.pureattire_capstoneproject_info6134.activities.ShoppingActivity
import com.example.pureattire_capstoneproject_info6134.databinding.FragmentIntroductionBinding
//import com.example.pureattire_capstoneproject_info6134.viewmodel.IntroductionViewModel
//import com.example.pureattire_capstoneproject_info6134.viewmodel.IntroductionViewModel.Companion.ACCOUNT_OPTIONS_FRAGMENT
//import com.example.pureattire_capstoneproject_info6134.viewmodel.IntroductionViewModel.Companion.SHOPPING_ACTIVITY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

class  IntroductionFragment:Fragment(R.layout.fragment_introduction) {
    private lateinit var binding: FragmentIntroductionBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntroductionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.buttonStart.setOnClickListener {
            // viewModel.startButtonClick()
            findNavController().navigate(R.id.action_introductionFragment_to_accountOptionsFragment)
        }
    }
}