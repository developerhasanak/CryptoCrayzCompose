package com.ak.cryptocrayzcompose.service

import com.ak.cryptocrayzcompose.di.aa
import com.ak.cryptocrayzcompose.model.Crypto
import com.ak.cryptocrayzcompose.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoAPI {

    @GET("coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&locale=tr")
    suspend fun getCryptoList() : CryptoList

    @GET("coins/{id}")
    suspend fun getCrypto(
        @Path("id") id : String
    ) : aa

    /*@GET("cryptolist.json")
    suspend fun getCryptoList(): CryptoList

    @GET("crypto.json")
    suspend fun getCrypto(): Crypto
*/

}