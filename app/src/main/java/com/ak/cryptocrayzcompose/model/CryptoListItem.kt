package com.ak.cryptocrayzcompose.model

import com.google.gson.annotations.SerializedName

data class CryptoListItem(
    @SerializedName("id")
    val id : String,
    @SerializedName("symbol")
    val currency: String,
    @SerializedName("current_price")
    val price: String
)