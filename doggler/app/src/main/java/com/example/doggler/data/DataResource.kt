package com.example.doggler.data

import com.example.doggler.R
import com.example.doggler.model.Dog

object DataResource {
    val dogs: List<Dog> = listOf(
        Dog(
            R.drawable.tzeitel,
            "Tzeitel",
            "7",
            "sunbathing"
        ),
        Dog(
            R.drawable.leroy,
            "Leroy",
            "4",
            "sleeping in dangerous places"
        ),
        Dog(
            R.drawable.frankie,
            "Frankie",
            "2",
            "stealing socks"
        ),
        Dog(
            R.drawable.nox,
            "Nox",
            "8",
            "meeting new animals"
        ),
        Dog(
            R.drawable.faye,
            "Faye",
            "8",
            "Digging in the garden"
        ),
        Dog(
            R.drawable.bella,
            "Bella",
            "14",
            "Chasing sea foam"
        )
    )
}