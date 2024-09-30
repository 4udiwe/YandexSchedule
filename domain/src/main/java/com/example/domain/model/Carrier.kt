package com.example.domain.model


data class Carrier(

    var code: Int? = null,
    var contacts: String? = null,
    var url: String? = null,
    var logoSvg: String? = null,
    var title: String? = null,
    var phone: String? = null,
    var codes: Codes? = Codes(),
    var address: String? = null,
    var logo: String? = null,
    var email: String? = null

)