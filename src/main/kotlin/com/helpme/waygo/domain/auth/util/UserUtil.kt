package com.helpme.waygo.domain.auth.util

import com.helpme.waygo.domain.auth.entity.User
import com.helpme.waygo.domain.auth.repository.UserRepository
import com.helpme.waygo.global.exception.exceptions.UserNotFoundException
import com.helpme.waygo.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class UserUtil(
    private val userRepository: UserRepository
) {
    fun fetchCurrentUser(): User {
        val principal = SecurityContextHolder.getContext().authentication.principal
        val phoneNum = if (principal is UserDetails) {
            (principal as AuthDetails).username
        } else {
            principal.toString()
        }
        return fetchUserByPhoneNum(phoneNum)
    }

    private fun fetchUserByPhoneNum(phoneNum: String): User =
        userRepository.findByPhoneNum(phoneNum) ?: throw UserNotFoundException()
}
