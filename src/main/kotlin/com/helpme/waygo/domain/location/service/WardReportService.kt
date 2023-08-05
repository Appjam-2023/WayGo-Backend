package com.helpme.waygo.domain.location.service

import com.helpme.waygo.domain.auth.repository.UserRepository
import com.helpme.waygo.domain.auth.util.UserUtil
import com.helpme.waygo.global.sms.SmsUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class WardReportService(
    private val userRepository: UserRepository,
    private val userUtil: UserUtil,
    private val smsUtil: SmsUtil
) {
    fun execute() {
        val user = userUtil.fetchCurrentUser()
        val guardians = userRepository.findAllById(user.guardianId)
        for(g in guardians) {
            smsUtil.sendSMS(g.phoneNum, "긴급상황 ${user.name}님이 도움을 요청하셨습니다")
        }
    }
}