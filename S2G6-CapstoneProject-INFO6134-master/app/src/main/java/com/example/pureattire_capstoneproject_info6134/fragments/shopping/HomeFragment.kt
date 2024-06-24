package com.example.pureattire_capstoneproject_info6134.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pureattire_capstoneproject_info6134.R
import com.example.pureattire_capstoneproject_info6134.adapters.HomeViewpagerAdapter
import com.example.pureattire_capstoneproject_info6134.databinding.FragmentHomeBinding
import com.example.pureattire_capstoneproject_info6134.fragments.categories.AbayaFragment
import com.example.pureattire_capstoneproject_info6134.fragments.categories.BishtFragment
import com.example.pureattire_capstoneproject_info6134.fragments.categories.HijabFragment
import com.example.pureattire_capstoneproject_info6134.fragments.categories.JilabsFragment
import com.example.pureattire_capstoneproject_info6134.fragments.categories.JubbasFragment
import com.example.pureattire_capstoneproject_info6134.fragments.categories.KufisFragment
import com.example.pureattire_capstoneproject_info6134.fragments.categories.MainCategoryFragment
import com.example.pureattire_capstoneproject_info6134.fragments.categories.SportsWearFragment
import com.example.pureattire_capstoneproject_info6134.fragments.categories.ThobeFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf(
            MainCategoryFragment(),
            AbayaFragment(),
            ThobeFragment(),
            HijabFragment(),
            KufisFragment(),
            JilabsFragment(),
            JubbasFragment(),
            BishtFragment(),
            SportsWearFragment(),
        )

        binding.viewpagerHome.isUserInputEnabled = false

        val viewPager2Adapter =
            HomeViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerHome) { tab, position ->
            when (position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "Abaya"
                2 -> tab.text = "Thobes"
                3 -> tab.text = "Hijabs"
                4 -> tab.text = "Kufis"
                5 -> tab.text = "Jilabs"
                6 -> tab.text = "Jubbas"
                7 -> tab.text = "Bisht"
                8 -> tab.text = "Sports Wear"
            }
        }.attach()
    }
}