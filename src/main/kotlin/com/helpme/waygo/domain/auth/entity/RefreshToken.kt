package com.helpme.waygo.domain.auth.entity

import com.helpme.waygo.global.security.jwt.JwtProvider
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import javax.persistence.Id

@RedisHash(value = "refreshToken", timeToLive = JwtProvider.REFRESH_EXP)
class RefreshToken(
    @Id
    @Indexed
    val id: Long,
    @Indexed
    val token: String
)