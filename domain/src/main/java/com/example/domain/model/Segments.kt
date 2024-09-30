package com.example.domain.model


data class Segments(

    var arrival: String? = null,
    var from: From? = From(),
    var thread: Thread? = Thread(),
    var departurePlatform: String? = null,
    var departure: String? = null,
    var stops: String? = null,
    var departureTerminal: String? = null,
    var to: To? = To(),
    var hasTransfers: Boolean? = null,
    var ticketsInfo: TicketsInfo? = TicketsInfo(),
    var duration: Int? = null,
    var arrivalTerminal: String? = null,
    var startDate: String? = null,
    var arrivalPlatform: String? = null

)