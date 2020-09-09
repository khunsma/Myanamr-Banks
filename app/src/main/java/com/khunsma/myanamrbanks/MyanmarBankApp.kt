package com.khunsma.myanamrbanks

import android.app.Application

class MyanmarBankApp : Application() {
    companion object {
        lateinit var INSTANCE: MyanmarBankApp
    }

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}