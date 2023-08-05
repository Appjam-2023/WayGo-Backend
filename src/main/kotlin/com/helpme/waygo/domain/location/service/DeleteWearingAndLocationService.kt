package com.helpme.waygo.domain.location.service

import com.helpme.waygo.domain.auth.util.UserUtil
import com.helpme.waygo.domain.location.exception.LocationNotFoundException
import com.helpme.waygo.domain.location.repository.LocationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class DeleteWearingAndLocationService(
    private val locationRepository: LocationRepository,
    private val userUtil: UserUtil
) {
    fun execute() {
        val user = userUtil.fetchCurrentUser()
        locationRepository.delete(user.location ?: throw LocationNotFoundException())
        user.location = null
    }
}