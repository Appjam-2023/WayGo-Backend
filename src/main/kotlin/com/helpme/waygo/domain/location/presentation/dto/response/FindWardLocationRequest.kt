package com.helpme.waygo.domain.location.presentation.dto.response

data class FindWardLocationRequest(
    val wardLocationRequest: List<SingleWardLocationRequest>
) {
    data class SingleWardLocationRequest(
        val id: Long,
        val name: String,
        val longitude: Double,
        val latitude: Double
    )
}