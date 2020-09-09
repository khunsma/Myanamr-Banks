package com.khunsma.myanamrbanks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.khunsma.myanamrbanks.data.BankRepository
import com.khunsma.myanamrbanks.data.BankRepositoryImpl
import com.khunsma.myanamrbanks.data.model.Bank

class MainViewModel(private val repository: BankRepository = BankRepositoryImpl()) : ViewModel() {
    fun getBankList(): LiveData<List<Bank>> = repository.getBankLists()
}