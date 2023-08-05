package com.helpme.waygo.domain.location.service

import com.helpme.waygo.domain.auth.repository.UserRepository
import com.helpme.waygo.global.exception.exceptions.UserNotFoundException
import com.helpme.waygo.global.sms.SmsUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GuardianReportService(
    private val userRepository: UserRepository,
    private val smsUtil: SmsUtil
) {
    fun execute(userId: Long) {
        val user = userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException()
        smsUtil.sendSMS("112", "지금 ${user.name}분이 위급 상황에 처했으며, 신고 위치는 위도 ${user.location!!.latitude} 경도 ${user.location!!.longitude}입니다")
    }
}