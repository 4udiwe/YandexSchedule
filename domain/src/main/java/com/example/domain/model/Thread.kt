package com.example.domain.model

data class Thread(

    var number           : String?              = null,
    var title            : String?              = null,
    var shortTitle       : String?              = null,
    var expressType      : String?              = null,
    var transportType    : String?              = null,
    var carrier          : Carrier?             = Carrier(),
    var uid              : String?              = null,
    var vehicle          : String?              = null,
    var transportSubtype : TransportSubtype?    = TransportSubtype(),
    var threadMethodLink : String?              = null

)