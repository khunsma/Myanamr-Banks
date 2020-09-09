package com.khunsma.myanamrbanks.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khunsma.myanamrbanks.data.model.Bank
import com.khunsma.myanamrbanks.data.model.BankResponse
import com.khunsma.myanamrbanks.data.net.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BankRepositoryImpl : BankRepository {

    private val retrofitClient = RetrofitClient()

    override fun getBankLists(): LiveData<List<Bank>> {
        val data = MutableLiveData<List<Bank>>()
        retrofitClient.getBankLists().enqueue(object : Callback<BankResponse> {
            override fun onResponse(call: Call<BankResponse>, response: Response<BankResponse>) {
                data.value = response.body()?.data
            }

            override fun onFailure(call: Call<BankResponse>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}