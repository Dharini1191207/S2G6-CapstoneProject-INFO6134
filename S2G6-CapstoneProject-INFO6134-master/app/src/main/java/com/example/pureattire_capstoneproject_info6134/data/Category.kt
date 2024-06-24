package com.example.pureattire_capstoneproject_info6134.data

sealed class Category(val category: String) {

    object Abaya: Category("Abaya")
    object Bisht: Category("Bisht")
    object Hijab: Category("Hijab")
    object Jilabs: Category("Jilabs")
    object Jubbas: Category("Jubbas")
    object Kufis: Category("Kufis")
    object SportsWear: Category("SportsWear")
    object Thobe: Category("Thobe")

}