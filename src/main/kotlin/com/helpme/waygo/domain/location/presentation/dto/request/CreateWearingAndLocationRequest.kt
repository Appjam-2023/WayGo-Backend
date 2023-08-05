package com.helpme.waygo.domain.location.presentation.dto.request

data class CreateWearingAndLocationRequest(
    val imgUrl: String,
    val longitude: Double,
    val latitude: Double
)