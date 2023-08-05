package com.helpme.waygo.domain.auth.repository

import com.helpme.waygo.domain.auth.entity.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository

interface RefreshTokenRepository: JpaRepository<RefreshToken, Long>