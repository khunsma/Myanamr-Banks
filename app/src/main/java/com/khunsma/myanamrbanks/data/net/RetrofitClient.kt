package com.khunsma.myanamrbanks.data.net

import com.khunsma.myanamrbanks.BuildConfig
import com.khunsma.myanamrbanks.data.model.BankResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val bankApi:BankApi

    companion object{
        private const val api_id =BuildConfig.APP_ID
        private const val secretKey=BuildConfig.SECRET_KEY
        private const val base_url=BuildConfig.BASE_URL
    }

    init {
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        bankApi = retrofit.create(BankApi::class.java)
    }

    fun getBankLists():Call<BankResponse>{
        return bankApi.getBankList(apiId = api_id, secretKey= secretKey)
    }
}