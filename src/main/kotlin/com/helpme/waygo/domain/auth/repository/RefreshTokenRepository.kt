package com.helpme.waygo.domain.auth.repository

import com.helpme.waygo.domain.auth.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshToken, Long>