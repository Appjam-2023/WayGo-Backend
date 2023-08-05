package com.helpme.waygo.domain.auth.presentation.dto.request

import com.helpme.waygo.auth.enum.UserRole

data class SignUpRequest(
    val phoneNum: String,
    val name: String,
    val role: UserRole,
    val password: String,
    val guardianNum: List<String>,
    val wardNum: List<String>
)