package com.helpme.waygo.domain.auth.service

import com.helpme.waygo.domain.auth.entity.RefreshToken
import com.helpme.waygo.domain.auth.exception.PasswordMismatchException
import com.helpme.waygo.domain.auth.presentation.dto.request.SignInRequest
import com.helpme.waygo.domain.auth.presentation.dto.response.SignInResponse
import com.helpme.waygo.domain.auth.repository.RefreshTokenRepository
import com.helpme.waygo.domain.auth.repository.UserRepository
import com.helpme.waygo.global.exception.exceptions.UserNotFoundException
import com.helpme.waygo.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class SignInService(
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtProvider
) {
    fun execute(signInRequest: SignInRequest): SignInResponse {
        val user = userRepository.findByPhoneNum(signInRequest.phoneNum) ?: throw UserNotFoundException()

        if(!passwordEncoder.matches(signInRequest.password, user.password))
            throw PasswordMismatchException()

        val (accessToken, refreshToken) = jwtProvider
            .run { generateAccessToken(signInRequest.phoneNum) to generateRefreshToken(signInRequest.phoneNum) }

        val expiresAt = jwtProvider.getAccessExpiredTime()

        refreshTokenRepository.save(RefreshToken(user.id, refreshToken))
        return SignInResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiredAt = expiresAt
        )
    }
}