package com.khunsma.myanamrbanks.data

import androidx.lifecycle.LiveData
import com.khunsma.myanamrbanks.data.model.Bank

interface BankRepository {
    fun getBankLists(): LiveData<List<Bank>>
}