package com.example.pureattire_capstoneproject_info6134.util

import android.view.View
import androidx.fragment.app.Fragment
import com.example.pureattire_capstoneproject_info6134.R
import com.example.pureattire_capstoneproject_info6134.activities.ShoppingActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

fun Fragment.hideBottomNavigationView(){
    val bottomNavigationView =
        (activity as ShoppingActivity).findViewById<BottomNavigationView>(
            com.example.pureattire_capstoneproject_info6134.R.id.bottomNavigation
        )
    bottomNavigationView.visibility = android.view.View.GONE
}

fun Fragment.showBottomNavigationView(){
    val bottomNavigationView =
        (activity as ShoppingActivity).findViewById<BottomNavigationView>(
            com.example.pureattire_capstoneproject_info6134.R.id.bottomNavigation
        )
    bottomNavigationView.visibility = android.view.View.VISIBLE
}