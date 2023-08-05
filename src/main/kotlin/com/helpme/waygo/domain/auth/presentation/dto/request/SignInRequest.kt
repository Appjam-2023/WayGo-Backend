package com.helpme.waygo.domain.auth.presentation.dto.request

data class SignInRequest(
    val phoneNum: String,
    val password: String
)