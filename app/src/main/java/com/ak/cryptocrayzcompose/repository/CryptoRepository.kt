package com.ak.cryptocrayzcompose.repository

import com.ak.cryptocrayzcompose.di.aa
import com.ak.cryptocrayzcompose.model.Crypto
import com.ak.cryptocrayzcompose.model.CryptoList
import com.ak.cryptocrayzcompose.service.CryptoAPI
import com.ak.cryptocrayzcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api : CryptoAPI

) {
    suspend fun getCryptoList() : Resource<CryptoList> {
        val responce = try {
           api.getCryptoList()
        } catch (e:Exception) {
            return  Resource.Error("Error!..")
        }

        return Resource.Success(responce)
    }

    suspend fun getCrypto(id : String) : Resource<aa> {
         val response = try {
            api.getCrypto(id)
         } catch (e: Exception){
             return Resource.Error("Error..")
         }

        return Resource.Success(response)
    }

}