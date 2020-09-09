package com.khunsma.myanamrbanks.data.net

import com.khunsma.myanamrbanks.data.model.BankResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface BankApi {
    @GET("api/banks")
    fun getBankList(@Header("app-id") apiId:String, @Header("secret-key") secretKey: String): Call<BankResponse>
}