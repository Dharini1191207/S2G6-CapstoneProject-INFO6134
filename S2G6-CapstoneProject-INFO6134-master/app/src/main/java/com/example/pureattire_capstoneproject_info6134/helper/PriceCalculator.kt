package com.example.pureattire_capstoneproject_info6134.helper

import android.util.Log

class PriceCalculater

fun Float?.getProductPrice(price: Float): Float {
    // 'this' --> Percentage
    if (this == null)
        return price
    val remainingPricePercentage = 1f - this
    Log.d("PriceCalculater", "Remaining Price Percentage: $remainingPricePercentage")
    val priceAfterOffer = remainingPricePercentage * price
    Log.d("PriceCalculater", "Price after applying offer: $priceAfterOffer")

    return priceAfterOffer
}