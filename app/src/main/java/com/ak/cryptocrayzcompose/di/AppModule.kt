package com.ak.cryptocrayzcompose.di

import com.ak.cryptocrayzcompose.repository.CryptoRepository
import com.ak.cryptocrayzcompose.service.CryptoAPI
import com.ak.cryptocrayzcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCryptoRepository(
        api: CryptoAPI
    ) = CryptoRepository(api)

    @Singleton
    @Provides
    fun provideCryptoApi() : CryptoAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)

    }

}