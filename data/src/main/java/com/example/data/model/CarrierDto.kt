package com.example.data.model

import com.example.domain.model.Carrier
import com.google.gson.annotations.SerializedName


data class CarrierDto (

    @SerializedName("code"     ) var code     : Int?      = null,
    @SerializedName("title"    ) var title    : String?   = null,
    @SerializedName("codes"    ) var codes    : CodesDto? = CodesDto(),
    @SerializedName("address"  ) var address  : String?   = null,
    @SerializedName("url"      ) var url      : String?   = null,
    @SerializedName("email"    ) var email    : String?   = null,
    @SerializedName("contacts" ) var contacts : String?   = null,
    @SerializedName("phone"    ) var phone    : String?   = null,
    @SerializedName("logo"     ) var logo     : String?   = null,
    @SerializedName("logo_svg" ) var logoSvg  : String?   = null

){
    fun toDomain(): Carrier =
        Carrier(code, title, codes?.toDomain(), address, url, email, contacts, phone, logo, logoSvg)
}