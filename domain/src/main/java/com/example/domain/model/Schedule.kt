package com.example.domain.model


data class Schedule (

  var search           : Search?             = Search(),
  var segments         : ArrayList<Segments> = arrayListOf(),
  var intervalSegments : ArrayList<String>   = arrayListOf(),
  var pagination       : Pagination?         = Pagination()

)