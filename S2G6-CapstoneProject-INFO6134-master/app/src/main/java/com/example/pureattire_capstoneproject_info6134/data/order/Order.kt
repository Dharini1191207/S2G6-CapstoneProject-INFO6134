package com.example.pureattire_capstoneproject_info6134.data.order

import android.os.Parcelable
import com.example.pureattire_capstoneproject_info6134.data.Address
import com.example.pureattire_capstoneproject_info6134.data.CartProduct
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random.Default.nextLong

@Parcelize
data class Order(
    val orderStatus: String = "",
    val totalPrice: Float = 0f,
    val products: List<CartProduct> = emptyList(),
    val address: Address = Address(),
    val date: String = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Date()),
    val orderId: Long = nextLong(0,100_000_000_000) + totalPrice.toLong()
): Parcelable