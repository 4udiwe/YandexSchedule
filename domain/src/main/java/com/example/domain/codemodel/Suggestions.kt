package com.example.domain.codemodel


data class Suggestions (

    var suggests      : ArrayList<Suggests> = arrayListOf(),
    var totalFound    : Int?                   = null,
    var hasExactMatch : Boolean?               = null

)
