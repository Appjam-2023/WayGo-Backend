package com.helpme.waygo.global.security.auth

import com.helpme.waygo.domain.auth.repository.UserRepository
import com.helpme.waygo.global.exception.exceptions.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByPhoneNum(username) ?: throw UserNotFoundException()
        return AuthDetails(user)
    }
}