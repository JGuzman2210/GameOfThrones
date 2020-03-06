package com.softhk.gameofthronesclone.data.remote.api

import com.softhk.gameofthronesclone.data.remote.ApiCharacterService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private val BASE_URL: String = "http://5e5c811997d2ea001479696d.mockapi.io/api/v1/"

    private fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiCharacterService(): ApiCharacterService =
        getRetrofit().create(ApiCharacterService::class.java)

}