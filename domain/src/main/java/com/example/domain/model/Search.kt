package com.example.domain.model


data class Search (

    var from : From? = From(),
    var to   : To?   = To(),
    var date : String?  = null

)