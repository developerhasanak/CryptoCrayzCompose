package com.ak.cryptocrayzcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.ak.cryptocrayzcompose.di.aa
import com.ak.cryptocrayzcompose.model.Crypto
import com.ak.cryptocrayzcompose.repository.CryptoRepository
import com.ak.cryptocrayzcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) :ViewModel() {

    suspend fun getCrypto(id:String) : Resource<aa> {
       return repository.getCrypto(id)
    }

}