package com.ak.cryptocrayzcompose.model

import com.google.gson.annotations.SerializedName

data class CryptoItem(
   @SerializedName("symbol")
   val id: String,
   @SerializedName("image")
   val logo_url: String,
   @SerializedName("name")
   val name: String
)