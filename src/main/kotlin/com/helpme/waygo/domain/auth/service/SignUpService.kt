package com.helpme.waygo.domain.auth.service

import com.helpme.waygo.domain.auth.entity.User
import com.helpme.waygo.auth.enum.UserRole
import com.helpme.waygo.domain.auth.exception.PhoneNumberExistException
import com.helpme.waygo.domain.auth.presentation.dto.request.SignUpRequest
import com.helpme.waygo.domain.auth.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class SignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun execute(signUpRequest: SignUpRequest) {

        if(userRepository.existsByPhoneNum(signUpRequest.phoneNum))
            throw PhoneNumberExistException()

        if(signUpRequest.role == UserRole.ROLE_GUARDIAN) {
            val ids = userRepository.findAllByPhoneNum(signUpRequest.wardNum)
                .map { it.id }.toMutableList()

            val user = User(
                phoneNum = signUpRequest.phoneNum,
                name = signUpRequest.name,
                password = passwordEncoder.encode(signUpRequest.password),
                userRole = mutableListOf(signUpRequest.role),
                wardId = ids
            )

            userRepository.save(user)
        }
        else if(signUpRequest.role == UserRole.ROLE_WARD) {
            val ids = userRepository.findAllByPhoneNum(signUpRequest.guardianNum)
                .map { it.id }.toMutableList()

            val user = User(
                phoneNum = signUpRequest.phoneNum,
                name = signUpRequest.name,
                password = passwordEncoder.encode(signUpRequest.password),
                userRole = mutableListOf(signUpRequest.role),
                guardianId = ids
            )

            userRepository.save(user)
        }
    }
}