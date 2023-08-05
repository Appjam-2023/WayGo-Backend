package com.helpme.waygo.domain.location.presentation.dto.request

import com.helpme.waygo.domain.auth.entity.User
import com.helpme.waygo.domain.location.entity.Location

data class CreateWearingAndLocationRequest(
    val imgUrl: String,
    val longitude: Double,
    val latitude: Double
) {
    fun toEntity(user: User, location: Location): User =
        User(
            id = user.id,
            name = user.name,
            phoneNum = user.phoneNum,
            password = user.password,
            userRole = user.userRole,
            guardianId = user.guardianId,
            wardId = user.wardId,
            location = location
        )
}