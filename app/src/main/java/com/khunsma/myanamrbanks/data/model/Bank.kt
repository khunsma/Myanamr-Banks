package com.khunsma.myanamrbanks.data.model

import java.io.Serializable

data class Bank(
    var id: Int? = null,
    var name: String? = null,
    var description: String? = null,
    var type: String? = null,
    var maxAmount: String? = null,
    var length: Int? = null,
    var startColor: String? = null,
    var centerColor: String? = null,
    var endColor: String? = null,
    var bgColor: String? = null,
    var fontColor: String? = null,
    var logoUrl: String? = null,
    var logoThumbnail: String? = null,
    var instruction1: String? = null,
    var instruction2: String? = null,
    var enabled: Int? = null,
    var created_at: String? = null,
    var updated_at: String? = null,
    var deleted_at: String? = null,
    var is_major: Boolean? = null,
    var logo_url: String? = null
) : Serializable