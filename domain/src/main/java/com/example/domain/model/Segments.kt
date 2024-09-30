package com.example.domain.model


data class Segments (

     var thread            : Thread? = Thread(),
     var stops             : String? = null,
     var from              : From?   = From(),
     var to                : To?     = To(),
     var departurePlatform : String? = null,
     var arrivalPlatform   : String? = null,
     var departureTerminal : String? = null,
     var arrivalTerminal   : String? = null,
     var duration          : Int?    = null,
     var days              : String? = null,
     var exceptDays        : String? = null,
     var departure         : String? = null,
     var arrival           : String? = null,
     var startDate         : String? = null

)