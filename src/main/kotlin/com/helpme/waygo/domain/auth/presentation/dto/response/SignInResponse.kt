package com.helpme.waygo.domain.auth.presentation.dto.response

import java.time.ZonedDateTime

data class SignInResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: ZonedDateTime
)