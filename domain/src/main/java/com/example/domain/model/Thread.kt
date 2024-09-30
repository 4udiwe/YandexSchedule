package com.example.domain.model


data class Thread(

    var uid: String? = null,
    var title: String? = null,
    var number: String? = null,
    var shortTitle: String? = null,
    var threadMethodLink: String? = null,
    var carrier: Carrier? = Carrier(),
    var transportType: String? = null,
    var vehicle: String? = null,
    var transportSubtype: TransportSubtype? = TransportSubtype(),
    var expressType: String? = null

)