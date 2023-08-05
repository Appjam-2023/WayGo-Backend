package com.helpme.waygo.domain.location.service

import com.helpme.waygo.domain.auth.repository.UserRepository
import com.helpme.waygo.domain.auth.util.UserUtil
import com.helpme.waygo.domain.location.presentation.dto.response.FindWardLocationRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class FindWardLocationService(
    private val userUtil: UserUtil,
    private val userRepository: UserRepository
) {
    fun execute(): FindWardLocationRequest {
        val user = userUtil.fetchCurrentUser()
        val response = FindWardLocationRequest(userRepository.findAllById(user.wardId)
            .map { FindWardLocationRequest.SingleWardLocationRequest(
                id = it.id,
                name = it.name,
                latitude = it.location!!.latitude,
                longitude = it.location!!.longitude
            ) })
        return response
    }
}