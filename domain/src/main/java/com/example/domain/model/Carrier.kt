package com.example.domain.model

data class Carrier (

    var code     : Int?      = null,
    var title    : String?   = null,
    var codes    : Codes?    = Codes(),
    var address  : String?   = null,
    var url      : String?   = null,
    var email    : String?   = null,
    var contacts : String?   = null,
    var phone    : String?   = null,
    var logo     : String?   = null,
    var logoSvg  : String?   = null

)