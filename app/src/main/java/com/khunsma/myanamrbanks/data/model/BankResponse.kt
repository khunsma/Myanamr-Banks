package com.khunsma.myanamrbanks.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BankResponse(
    @SerializedName("code")
    @Expose
    var code: Int? = null,
    @SerializedName("message")
    @Expose
    var message: String? = null,
    @SerializedName("data")
    @Expose
    var data: List<Bank>
)