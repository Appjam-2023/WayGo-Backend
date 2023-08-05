package com.helpme.waygo.domain.location.service

import com.helpme.waygo.domain.auth.util.UserUtil
import com.helpme.waygo.domain.location.entity.Location
import com.helpme.waygo.domain.location.presentation.dto.request.CreateWearingAndLocationRequest
import com.helpme.waygo.domain.location.repository.LocationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class CreateWearingAndLocationService(
    private val locationRepository: LocationRepository,
    private val userUtil: UserUtil
) {
    fun execute(createWearingAndLocationRequest: CreateWearingAndLocationRequest) {

        val user = userUtil.fetchCurrentUser()

        val location = Location(
            longitude = createWearingAndLocationRequest.longitude,
            latitude = createWearingAndLocationRequest.latitude,
            imgUrl = createWearingAndLocationRequest.imgUrl,
            user = user
        )

        locationRepository.save(location)
    }
}