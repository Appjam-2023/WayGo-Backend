package com.helpme.waygo.domain.location.service

import com.helpme.waygo.domain.auth.repository.UserRepository
import com.helpme.waygo.domain.auth.util.UserUtil
import com.helpme.waygo.domain.location.exception.LocationNotFoundException
import com.helpme.waygo.domain.location.repository.LocationRepository
import com.helpme.waygo.global.exception.exceptions.UserNotFoundException
import com.helpme.waygo.global.sms.SmsUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import javax.servlet.http.HttpServletRequest


@Service
@Transactional(rollbackFor = [Exception::class])
class DeleteWearingAndLocationService(
    private val locationRepository: LocationRepository,
    private val userRepository: UserRepository,
    private val userUtil: UserUtil,
    private val smsUtil: SmsUtil
) {
    fun execute(httpServletRequest: HttpServletRequest) {
        val user = userUtil.fetchCurrentUser()
        for(p in user.guardianId) {
            val guardian = userRepository.findByIdOrNull(p) ?: throw UserNotFoundException()
            smsUtil.sendSMS("01033791016", "박시원시바롬")
        }
        locationRepository.delete(user.location ?: throw LocationNotFoundException())
        user.location = null
    }
}