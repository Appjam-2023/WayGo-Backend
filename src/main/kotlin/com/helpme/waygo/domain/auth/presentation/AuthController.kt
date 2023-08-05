package com.helpme.waygo.domain.auth.presentation

import com.helpme.waygo.domain.auth.presentation.dto.request.SignInRequest
import com.helpme.waygo.domain.auth.presentation.dto.request.SignUpRequest
import com.helpme.waygo.domain.auth.presentation.dto.response.SignInResponse
import com.helpme.waygo.domain.auth.service.SignInService
import com.helpme.waygo.domain.auth.service.SignUpService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val signUpService: SignUpService,
    private val signInService: SignInService
) {
    @PostMapping("signup")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<Void> {
        signUpService.execute(signUpRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PostMapping
    fun signIn(@RequestBody signInRequest: SignInRequest): ResponseEntity<SignInResponse> {
        val result = signInService.execute(signInRequest)
        return ResponseEntity.ok(result)
    }
}