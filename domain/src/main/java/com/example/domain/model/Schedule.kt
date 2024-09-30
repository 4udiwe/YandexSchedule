package com.example.domain.model


data class Schedule (

    var pagination       : Pagination?                 = Pagination(),
    var intervalSegments : ArrayList<IntervalSegments> = arrayListOf(),
    var segments         : ArrayList<Segments>         = arrayListOf(),
    var search           : Search?                     = Search()

)