package com.example.domain.model


data class Search(

    var date: String? = null,
    var to: To? = To(),
    var from: From? = From()

)