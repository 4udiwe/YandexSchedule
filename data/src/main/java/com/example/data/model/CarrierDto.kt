package com.example.data.model

import com.example.domain.model.Carrier
import com.google.gson.annotations.SerializedName


data class CarrierDto(

    @SerializedName("code") var code: Int? = null,
    @SerializedName("contacts") var contacts: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("logo_svg") var logoSvg: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("codes") var codes: CodesDto? = CodesDto(),
    @SerializedName("address") var address: String? = null,
    @SerializedName("logo") var logo: String? = null,
    @SerializedName("email") var email: String? = null

) {
    fun toDomain() : Carrier{
        return Carrier(
            code, contacts, url, logoSvg, title, phone, codes?.toDomain(), address, logo, email
        )
    }
}